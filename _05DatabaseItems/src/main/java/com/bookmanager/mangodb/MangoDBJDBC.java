package com.bookmanager.mangodb;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/**
 * Mango DB
 *
 * @author MaxBrooks 15905898514@163.com
 * @version 2023/4/6 16:33
 * @since JDK17
 */

public class MangoDBJDBC {

//    public static void main( String args[] ){
//        try{
//            // 连接到 mongodb 服务
//            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
//
//            // 连接到数据库
//            MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
//            Logger.getGlobal().info("Connect to database successfully");
//
//            MongoCollection<Document> collection = mongoDatabase.getCollection("test");
//            System.out.println("集合 test 选择成功");
//
//            //检索所有文档
//            /*
//             * 1. 获取迭代器FindIterable<Document>
//             * 2. 获取游标MongoCursor<Document>
//             * 3. 通过游标遍历检索出的文档集合
//             * */
//            FindIterable<Document> findIterable = collection.find();
//            for (Document document : findIterable) {
//                Logger.getGlobal().info("" + document);
//            }
//
//        }catch(Exception e){
//            Logger.getGlobal().warning(e.getClass().getName() + ": " + e.getMessage());
//        }
//    }

    public static void main(String[] args) {
        // 创建 MongoDB 连接
        MongoClient mongo = new MongoClient( "localhost" , 27017 );
        // 连接到 MongoDB
        MongoCredential credential;
        credential = MongoCredential.createCredential("root", "test", "Shangxiao111".toCharArray());
        Logger.getGlobal().info("数据库连接成功");
        // 访问数据库
        MongoDatabase database = mongo.getDatabase("test");
        // 检索集合
        MongoCollection<Document> collection = database.getCollection("tutorial");
        System.out.println("成功选择了集合 tutorial");
        // 删除文档
        collection.deleteOne(Filters.eq("title", "MongoDB"));
        System.out.println("文档删除成功...");
        // 更新后检索文档
        // 获取 iterable 对象
        FindIterable<Document> iterDoc = collection.find();
        int i = 1;
        // 获取迭代器
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            Logger.getGlobal().info((String) it.next());
            i++;
        }
    }
}
