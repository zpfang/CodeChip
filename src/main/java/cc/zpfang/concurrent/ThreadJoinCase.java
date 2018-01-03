package cc.zpfang.concurrent;

/**
 * Description:
 * Created by fangzp on 2017-11-16.
 */
public class ThreadJoinCase {

    public static void main(String[] args) throws InterruptedException {
        Thread worker1 = new Thread(new Worker());
        Thread worker2 = new Thread(new Worker());
        System.out.println("start works");
        worker1.start();
        worker2.start();
        worker1.join();
        worker2.join();
        System.out.println("end works");
    }

    static class Worker implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("work " + Thread.currentThread().getId()+ ", start");
                Thread.sleep(5000);
                System.out.println("work " + Thread.currentThread().getId()+ ", end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
