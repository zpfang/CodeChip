package cc.zpfang.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:
 * Created by fangzp on 2017-11-16.
 */
public class ThreadPoolCase {
    private static ExecutorService executorService = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread-1 start");
                    Thread.sleep(5000);
                    System.out.println("Thread-1 end");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("start thread #2");

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Thread-2 start");
                    Thread.sleep(5000);
                    System.out.println("Thread-2 end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("end main thread");
    }

}
