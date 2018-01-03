package cc.zpfang.mongo;

/**
 * Description:
 * Created by fangzp on 2017-12-08.
 */
public class MongoDBAsyncCase {


   /* public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static CountDownLatch gloabLatch = new CountDownLatch(1);

    public static volatile long id = 0;


    public static void main(String[] args) {

// To directly connect to the default server localhost on port 27017
        MongoClient mongoClient = null;
        try {

            mongoClient = MongoClients.create("mongodb://192.168.70.28:27017");


//获取数据库
            MongoDatabase database = mongoClient.getDatabase("mydb");
            MongoCollection<Document> col = database.getCollection("mycollection");

            MongoDBAsyncCase test = new MongoDBAsyncCase();
            test.testInsert(col);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    *//**
     * 控制线程
     *
     * @param col
     *//*
    private void testInsert(MongoCollection<Document> col) {
        int insertNum = 1000;

        Runnable runner = new InsertThread(col, insertNum);
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + (startTime) + "ms");
        executorService.execute(runner);
        while (true) {
            if (id >= (insertNum - 1)) {
                executorService.shutdownNow();
                break;
            }
        }
        System.out.println("id=" + id);
        long endTime = System.currentTimeMillis();
        System.out.println("所有回调完成耗时：" + (endTime - startTime) + "ms");

    }


    *//**
     * 插入线程
     *
     * @author huqi
     *//*
    class InsertThread implements Runnable {
        private final MongoCollection<Document> col;

        private int insertNum;

        public InsertThread(MongoCollection<Document> col, int insertNum) {
            this.col = col;
            this.insertNum = insertNum;
        }

        private synchronized long addId() {
            return id++;
        }

        public void run() {
            try {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < insertNum; i++) {
                    //插入数据
                    Document doc = new Document("name", "MongoDB")
                          .append("type", "database")
                          .append("id", i)
                          .append("info", new Document("x", 203).append("y", 102));
                    col.insertOne(doc, new SingleResultCallback<Void>() {
                        @Override
                        public void onResult(final Void result, final Throwable t) {
                            addId();
                            if (t != null) {
                                System.out.println("save fail t=" + t);
                            }
                        }
                    });
                }

                long endTime = System.currentTimeMillis();
                System.out.println("所有插入命令调用完成，耗时：" + (endTime - startTime) + "ms");
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }*/

}
