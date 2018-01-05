package cc.zpfang.es.task;

import cc.zpfang.es.persistent.UserMapper;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * Created by zpfang on 2017/7/9.
 */
@Service
@Log4j
public class TaskInit implements InitializingBean {
    @Autowired
    private UserMapper userMapper;

    private Long count;

    public TaskInit() {
    }

    public void init(){
        count = userMapper.getCountUser();
        for (int i = 0; i < 100; i++) {
            Long start = count / 100 * i;
            Long end = count / 100 * (i + 1) - 1;
            end = end > count ? count : end;
            System.out.println("start :" + start + ", end :" + end);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
