package cc.zpfang.mongo;

import com.alibaba.fastjson.JSON;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import lombok.extern.java.Log;
import org.bson.Document;
import org.bson.codecs.UuidCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Description:
 * Created by fangzp on 2017-12-07.
 */
@Controller
@EnableAutoConfiguration
@Log
public class MongoDBCase {

    public static void main(String[] args) {

        CodecRegistry codecRegistry =
              CodecRegistries.fromRegistries(CodecRegistries.fromCodecs(new UuidCodec()),
                    MongoClient.getDefaultCodecRegistry());
        MongoClientOptions options = MongoClientOptions.builder()
              .codecRegistry(codecRegistry).build();
        MongoClient mongoClient = new MongoClient(new ServerAddress("192.168.70.28"), options);
      /*  MongoClientURI connectionString = new MongoClientURI("mongodb://192.168.70.28:27017");
        MongoClient mongoClient = new MongoClient(connectionString);*/

        MongoDatabase database = mongoClient.getDatabase("mydb");

        MongoCollection<Document> collection = database.getCollection("test");

        Document doc = new Document("name", "MongoDB1")
              .append("type", "database1")
              .append("count", 2)
              .append("versions", Arrays.asList("v3.2", "v3.0", "v2.6"))
              .append("info", new Document("x", 203).append("y", 102));
        collection.insertOne(doc);

        System.out.println("count: " + collection.count());

        Block<Document> block = new Block<Document>() {
            @Override
            public void apply(Document document) {
                System.out.println(JSON.toJSONString(document));
            }
        };

        collection.find(Filters.eq("name", "MongoDB1")).forEach(block);
       /* while (result.hasNext()){
            System.out.println(JSON.toJSONString(result.next()));
        }*/
        Document[] documents = (Document[]) Array.newInstance(Document.class, 10);
        //Consumer<? super T> action;

    }
}
