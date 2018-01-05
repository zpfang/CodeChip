package cc.zpfang.concurrent;

import lombok.extern.log4j.Log4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Description:
 * Created by fangzp on 2017-06-15.
 */
@Log4j
public class ConcurrentList {

    public static List<String> list = new CopyOnWriteArrayList<String>();
    private Executor executor = Executors.newFixedThreadPool(11);

    public static void main(String[] args) throws InterruptedException {
        ConcurrentList coun = new ConcurrentList();
        coun.init();

    }

    private void init(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (true){
                    list.add(String.valueOf(i));
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }
            }
        });

        for(int i = 0; i < 10; i++){
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        for(String item : list){
                            System.out.println(Thread.currentThread().getName()+"-"+item);
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }
}
