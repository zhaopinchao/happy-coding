package com.conding.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhaopc
 * @date 2020-05-06 22:03
 * @description
 */
public class IndexApiPractice {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = EsClient.getClient();
        Map<String, Object> jsonMap = new HashMap<>(3);
        jsonMap.put("user", "kimchy");
        jsonMap.put("postDate", System.currentTimeMillis());
        jsonMap.put("message", "trying out Elasticsearch");
        IndexRequest request = new IndexRequest("test");
        request.id("1").source(jsonMap);
        request.opType(DocWriteRequest.OpType.CREATE);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        ObjectMapper mapper = new ObjectMapper();
        String responseJson = mapper.writeValueAsString(response);
        System.out.println(responseJson);
        EsClient.close();
    }
}
