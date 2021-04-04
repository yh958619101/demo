/*
package com.yh;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yh.until.MongoDb;
import org.bson.BsonDocument;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mongodb.client.result.UpdateResult;

public class MongoTest {
    @Before
    public void before() {
        MongoDb.connect("test", "staff", "192.168.50.130", 27017);
        MongoDb.bsonConnect("test", "staff", "192.168.50.130", 27017);
    }

    @Test
    public void testInsert() {
        Document document = new Document();
        document.append("name", "gu").append("gender", "male");
        MongoDb.insert(document);
    }

    @Test
    public void testInsertMap() {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name", "lifeix");
        map.put("gender", "undefinded");
        Document document = new Document(map);
        MongoDb.insert(document);
    }

    @Test
    public void testInsertJson() {
        String json ="{'name':'neoyin','gender':'male','avatar':'/444.jpg'}";
        BsonDocument document = BsonDocument.parse(json);
        MongoDb.insertBsonDocument(document);
    }

    @Test
    public void testInsertJsonHaveChild() {
        String json ="{'name':'nick','gender':'male','avatar':'/1.jpg','teacher':[{'id':'0001','name':'gcc','age':'28'},{'id':'002','name':'gcc2','age':'27'}],'score':10}";
        BsonDocument document = BsonDocument.parse(json);
        MongoDb.insertBsonDocument(document);
    }

    @Test
    public void testFindAll() {
        List<Document> results = MongoDb.findAll();
        for (Document doc : results) {
            System.out.println(doc.toJson());
        }
    }

    @Test
    public void testFindBy() {
        Document filter = new Document();
        filter.append("name", "wang");
        List<Document> results = MongoDb.findBy(filter);
        for (Document doc : results) {
            System.out.println(doc.toJson());
        }
    }
    */
/**
     *  条件表达式
     *  $ge(>) $get(>=) $lt(<) $lte(<=) $ne(<>) $in $nin $all $exists
     *  $or $nor $where $type等等
     *//*

    @Test
    public void testFindByExpression() {
        Document expression = new Document();
        expression.append("score", new Document("$gte", 5));
        List<Document> results = MongoDb.findBy(expression);
        for (Document doc : results) {
            System.out.println(doc.toJson());
        }
    }

    @Test
    public void testUpdateOne() {
        Document filter = new Document();
        filter.append("gender", "male");

        // 注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("gender", "female"));
        UpdateResult result = MongoDb.updateOne(filter, update);
        System.out.println("matched count = " + result.getMatchedCount());
    }

    @Test
    public void testUpdateMany() {
        Document filter = new Document();
        filter.append("gender", "female");

        // 注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("gender", "male"));
        UpdateResult result = MongoDb.updateMany(filter, update);
        System.out.println("matched count = " + result.getMatchedCount());
    }

    @Test
    public void testReplace() {
        Document filter = new Document();
        filter.append("name", "wang");

        // 注意：更新文档时，不需要使用"$set"
        Document replacement = new Document();
        replacement.append("value", 123);
        MongoDb.replace(filter, replacement);
    }

    @Test
    public void testDeleteOne() {
        Document filter = new Document();
        filter.append("value",123);
        MongoDb.deleteOne(filter);
    }

    @Test
    public void testDeleteMany() {
        Document filter = new Document();
        filter.append("gender", "male");
        MongoDb.deleteMany(filter);
    }

    @After
    public void testCloseClient(){
        MongoDb.closeClient();
    }

}*/
