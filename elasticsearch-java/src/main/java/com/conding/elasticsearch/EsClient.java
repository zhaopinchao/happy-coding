package com.conding.elasticsearch;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author: zhaopc@tuya.com
 * @date: 2020-05-08 22:23
 * @description
 */
public class EsClient {

    private static RestHighLevelClient client = null;

    public static synchronized RestHighLevelClient getClient() {
        if (client == null) {
            client = new RestHighLevelClient(RestClient.builder(
                    new HttpHost("localhost", 9200, "http")
            ));
            return client;
        }
        return client;
    }

    public static synchronized void close() {
        if (client != null) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
