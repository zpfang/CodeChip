package cc.zpfang;

import cc.zpfang.es.task.TaskExcutor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Description:
 * Created by zpfang on 2017/7/9.
 */
@SpringBootApplication
@MapperScan("cc.zpfang.persistent")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        TaskExcutor taskExcutor = new TaskExcutor("test", 1L, 10L);
        taskExcutor.run();
    }
}