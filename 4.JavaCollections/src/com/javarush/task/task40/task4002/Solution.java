package com.javarush.task.task40.task4002;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* 
Опять POST, а не GET
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.sendPost("https://requestb.in/v2ha0gv2", "name=zapp&mood=good&locale=&id=777");
    }

    public void sendPost(String url, String urlParameters) throws Exception {
        HttpClient client = getHttpClient();
        HttpPost post = new HttpPost(url);

        post.addHeader("User-Agent", "Mozilla/5.0");

        // устанавливаем параметры запроса
        post.setEntity(new UrlEncodedFormEntity(parseParameters(urlParameters)));
        // ну или с помощью встроенных классов
        //post.setEntity(new UrlEncodedFormEntity(URLEncodedUtils.parse(urlParameters, Charset.defaultCharset())));

        HttpResponse response = client.execute(post);

        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String responseLine;
        while ((responseLine = bufferedReader.readLine()) != null) {
            result.append(responseLine);
        }

        System.out.println("Response: " + result.toString());
    }

    protected HttpClient getHttpClient() {
        return HttpClientBuilder.create().build();
    }

    private List<NameValuePair> parseParameters(String urlParameters) {
        List<NameValuePair> params = new ArrayList<>();
        for(String s: urlParameters.split("&"))
        {
            String[] items = s.split("=");
            if (items.length == 2) {
                params.add(new BasicNameValuePair(items[0], items[1]));
            }
            else if (items.length == 1) {
                params.add(new BasicNameValuePair(items[0], ""));
            }
        }
        return params;
    }
}
