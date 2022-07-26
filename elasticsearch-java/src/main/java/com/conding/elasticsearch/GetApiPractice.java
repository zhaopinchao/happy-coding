package com.conding.elasticsearch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.VersionType;

import java.io.IOException;

/**
 * @author zhaopc
 * @date 2020-05-08 22:27
 * @description
 */
public class GetApiPractice extends EsClient {

    public static void main(String[] args) {
        GetApiPractice practice = new GetApiPractice();
        RestHighLevelClient client = EsClient.getClient();
        try {
            Long start = System.currentTimeMillis();
//            Map<String, Object> jsonMap = new HashMap<>();
//            jsonMap.put("year", 2020);
//            jsonMap.put("postDate", System.currentTimeMillis());
//            jsonMap.put("title", "test elastic");
//            IndexRequest request = new IndexRequest("movies");
//            request.id("100000007").source(jsonMap);
//            request.routing("esrser");
//            request.opType(DocWriteRequest.OpType.CREATE);
//            IndexResponse response = client.index(request, RequestOptions.DEFAULT);
//            ObjectMapper mapper = new ObjectMapper();
//            String responseJson = mapper.writeValueAsString(response);
//            System.out.println(responseJson);

            GetRequest getRequest = new GetRequest("movies", "10000000");
            //可选参数: 数据源中包含哪些字段
//            String[] includes = new String[]{"year", "title"};
            //可选参数: 数据源中剔除哪些字段
//            String[] excludes = new String[]{"genre"};
            //可选参数: fetchSourceContext
            //从数据源中取数据,如果fetchSource为false,则不会获取数据,但是如果数据存在exists为true
//            FetchSourceContext fetchSourceContext =
//                    new FetchSourceContext(true, includes, excludes);
//            getRequest.fetchSourceContext(fetchSourceContext);
            //可选参数: 分片值，默认为id的值，es的分片路由算法为( hashcode(routing) % primary_sharding_count)
//            getRequest.routing("routing");
            //可选参数
            getRequest.preference("preference");
            //可选参数: 实时性,及时/延时. 如果参数是true则表示
            getRequest.realtime(false);
            //可选参数,如果version对应document的version
//            getRequest.version(1);
            getRequest.refresh(false);
            getRequest.versionType(VersionType.EXTERNAL_GTE);
            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
            ObjectMapper mapper1 = new ObjectMapper();
            String s = mapper1.writeValueAsString(getResponse);
            Long end = System.currentTimeMillis();
            System.out.println(s);
            System.out.println("耗时: " + (end - start));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EsClient.close();
        }
    }
}
