package cc.zpfang.es;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Description:
 * Created by fangzp on 2017-07-11.
 */
public class esTest {

    private TransportClient client;

    public esTest() {
        init();
    }

    public void init(){
        try {
            client = new PreBuiltTransportClient(Settings.EMPTY)
                  .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void index(){
        try {
            IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                  .setSource(jsonBuilder()
                        .startObject()
                        .field("user", "kimchy123")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                        .endObject()
                  ).get();
           // AggregationBuilders.sum("123").
           // System.out.println(JSON.toJSONString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        esTest test = new esTest();
        test.index();
    }
}
