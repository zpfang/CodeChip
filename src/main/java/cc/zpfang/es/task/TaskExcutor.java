package cc.zpfang.es.task;

import cc.zpfang.es.model.User;
import cc.zpfang.es.persistent.UserMapper;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Description:
 * Created by zpfang on 2017/7/9.
 */
public class TaskExcutor extends Thread{

    private Long start;
    private Long end;
    @Autowired
    private UserMapper userMapper;
    private Client client;

    public TaskExcutor(String name, Long start, Long end) {
        super(name);
        this.start = start;
        this.end = end;
        this.init();
    }

    private void init(){
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.108"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Long times = (end - start) / 10;
        for(int i = 0; i < times; i++){
            Long startOffset = start + 1000 * i;
            List<User> userList = userMapper.getUserList(startOffset);
            transformToEs(userList);
        }
    }

    private void transformToEs(List<User> userList){
        BulkRequestBuilder bulkRequestBuilder = client.prepareBulk();
        for(User user : userList){
            bulkRequestBuilder.add(client.prepareIndex("test", "user").setId(String.valueOf(user.getId())).setSource(JSON.toJSONString(user)));
        }
        BulkResponse bulkResponse = bulkRequestBuilder.execute().actionGet();

        bulkRequestBuilder.request().requests().clear();

        if (bulkResponse.hasFailures()){
            System.out.println("执行失败：" + bulkResponse.buildFailureMessage());
        }
    }

    public static void main(String[] args) {
        TaskExcutor taskExcutor = new TaskExcutor("test", 1L, 10L);
        taskExcutor.run();
    }
}
