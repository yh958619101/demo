package com.yh.ES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpRequestTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:9200/books/_search?pretty=true");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        if (con.getResponseCode() == 200) {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }
        }
    }
}
