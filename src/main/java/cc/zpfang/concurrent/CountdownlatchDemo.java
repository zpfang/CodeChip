package cc.zpfang.concurrent;

import lombok.extern.log4j.Log4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;

/**
 * Description:
 * Created by fangzp on 2017-06-15.
 */
@Log4j
public class CountdownlatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Work work1 = new Work("one", 5000, latch);
        Work work2 = new Work("two", 8000, latch);
        work1.start();
        work2.start();
        latch.await();
        log.info("all work done at " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }

    static class Work extends Thread{
        String workName;
        int workTime;
        CountDownLatch latch;

        public Work(String workName, int workTime, CountDownLatch latch){
            this.workName = workName;
            this.workTime = workTime;
            this.latch = latch;
        }

        public void run(){
            log.info("Worker:" + workName + " do work begin at " + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            doWork();
            log.info("Worker:" + workName + " do work complate at" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            latch.countDown();
            latch.countDown();
        }

        private void doWork(){
            try {
                Thread.sleep(workTime);
            } catch (InterruptedException e) {
                log.info(e);
            }
        }
    }
}
