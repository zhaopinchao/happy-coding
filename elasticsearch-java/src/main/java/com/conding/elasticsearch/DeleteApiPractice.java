package com.conding.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.VersionType;

import java.io.IOException;

/**
 * @author zhaopc
 * @date 2020-05-14 22:16
 * @description
 */
public class DeleteApiPractice {

    public static void main(String[] args) {
        RestHighLevelClient client = EsClient.getClient();
        //必填参数: index, documentId
        DeleteRequest request = new DeleteRequest("movies", "10000000");
        //可选参数: routing分片值，默认为id的值，es的分片路由算法为( hashcode(routing) % primary_sharding_count)
        request.routing("routing");
        //可选参数: 超时时间,如果超时就报错
        request.timeout(TimeValue.timeValueSeconds(2));
        //可选参数: 设置数据刷新机制
        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        //可选参数: 数据的版本号,如果版本不对,将无法进行删除,version_conflict_engine_exception
//        request.version(2);
        //可选参数: versionType 暂时不知作用
        request.versionType(VersionType.EXTERNAL);
        try {
            DeleteResponse delete = client.delete(request, RequestOptions.DEFAULT);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(delete));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            EsClient.close();
        }

    }
}
