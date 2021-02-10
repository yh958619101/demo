package com.yh.ES;

import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LowLevelTest3 {
    public static void main(String[] args) throws IOException {
        //1.构建一个 RestClient 对象
        RestClientBuilder builder = RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http"),
                new HttpHost("localhost", 9202, "http")
        );
        //2.如果需要在请求头中设置认证信息等，可以通过 builder 来设置
//        builder.setDefaultHeaders(new Header[]{new BasicHeader("key","value")});
        RestClient restClient = builder.build();
        //3.构建请求
        Request request = new Request("GET", "/books/_search");
        //添加请求参数
        request.addParameter("pretty","true");
        //添加请求体
        request.setEntity(new NStringEntity("{\"query\": {\"term\": {\"name\": {\"value\": \"java\"}}}}", ContentType.APPLICATION_JSON));
        //4.发起请求，发起请求有两种方式，可以同步，可以异步
        //异步请求
        restClient.performRequestAsync(request, new ResponseListener() {
            //请求成功的回调
            @Override
            public void onSuccess(Response response) {
                //5.解析 response，获取响应结果
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                    String str = null;
                    while ((str = br.readLine()) != null) {
                        System.out.println(str);
                    }
                    br.close();
                    //最后记得关闭 RestClient
                    restClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //请求失败的回调
            @Override
            public void onFailure(Exception e) {

            }
        });
    }
}