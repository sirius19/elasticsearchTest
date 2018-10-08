package com.wqb.test;

import com.wqb.es.ElasticSearchTestApplication;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * create by Administrator at 2018/10/7 21:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ElasticSearchTestApplication.class)
public class ElasticsearchTemplateTest {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void test(){
        Client client = elasticsearchTemplate.getClient();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch("call_think_log")
                .setTypes("call_think_log");
        SearchResponse searchResponse = searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery()).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        searchHits.forEach(hit->{
            System.out.println(hit.getSourceAsString());
        });
    }
}
