package org.example;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import java.io.IOException;


public class HttpClientHeaders {
    public static void main(String[] args) throws IOException {
        try {
            CloseableHttpClient client = HttpClients.custom().build();
            HttpPost request = new HttpPost("https://www.wikipedia.org/");
            CloseableHttpResponse response = client.execute(request);
            Header[] headers = response.getAllHeaders();
            for (Header header: headers) {
                System.out.println(header.getName() + " : " + header.getValue() );
            }
        } catch (Exception e){
            System.out.println(e);
        }


    }



}

