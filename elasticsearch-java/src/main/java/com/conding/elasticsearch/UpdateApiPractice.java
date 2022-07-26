package com.conding.elasticsearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @author zhaopc
 * @date 2020-05-11 23:09
 * @description
 */
public class UpdateApiPractice extends EsClient {

    public static void main(String[] args) {
        RestHighLevelClient client = EsClient.getClient();
        try {
            int count = 10;
            CountDownLatch latch = new CountDownLatch(count);
            for (int i = 0; i < count; i++) {
                new Thread(() -> {
                    doUpdate(client);
                    latch.countDown();
                }).start();
            }
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            EsClient.close();
        }
    }

    private static void doUpdate(RestHighLevelClient client) {
        //使用map设置参数
        Map<String, Object> jsonMap = new HashMap<>(1);
        jsonMap.put("year", 20212);

        UpdateRequest request = new UpdateRequest("movies", "1000000012").doc(jsonMap);
        //可选参数:文档不存在就新增
        request.docAsUpsert(true);
        //查询数据,相当于更新后查询操作,也可以使用fetchSourceContent进行配置
        request.fetchSource(true);
        //可选参数: 设置在继续更新操作之前必须处于活动状态的分片副本数。默认为 ActiveShardCount.DEFAULT = -2
        request.waitForActiveShards(ActiveShardCount.DEFAULT);
        //可选参数: seqNo相当于_version,记录数据的当前版本,如果设置不对,更新将会失败
//        request.setIfSeqNo(2L);
        //可选参数: PrimaryTerm 主要是用来记录数据存储在哪个主分片, 如果设置不对,更新将会失败
//        request.setIfPrimaryTerm(1L);
        //可选参数: 相当于检测是否更新数据,当更新数据与原数据相同时,如果设置为true那么result是NOOP并且不会去更新数据,如果设置为false,那么result是UPDATED并且会更新数据version会+1
        request.detectNoop(false);
        //可选参数: 如果当有另外的请求在更改数据时,会产生冲突,该参数为设置重试次数
        request.retryOnConflict(3);
        //可选参数: 设置数据写入刷新的策略,默认为NONE
        //NONE: 不关心数据是否完成刷新,直接返回结果;操作延时短、资源消耗低;实时性低.
        //WAIT_UNTIL: 等待数据完成刷新，然后再结束请求;实时性高、操作延时长;资源消耗低
        //IMMEDIATE:立即进行数据刷新，然后再结束请求;实时性高、操作延时短;资源消耗高;
        request.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL);
        //可选参数: 分片值，默认为id的值，es的分片路由算法为( hashcode(routing) % primary_sharding_count)
//        request.routing("routing");
        UpdateResponse update;
        try {
            update = client.update(request, RequestOptions.DEFAULT);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(update));

//            GetRequest getRequest = new GetRequest("movies", "1000000012");
//            GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
//            System.out.println(mapper.writeValueAsString(getResponse));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
