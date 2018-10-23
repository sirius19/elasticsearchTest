package com.wqb.test;

import com.wqb.es.ElasticSearchTestApplication;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHits;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

/**
 * create by Administrator at 2018/10/7 21:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ElasticSearchTestApplication.class)
public class ElasticsearchTemplateTest {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    private Client client;
    private SearchRequestBuilder searchRequestBuilder;

    @Before
    public void testBefore() {
        client = elasticsearchTemplate.getClient();
        searchRequestBuilder = client.prepareSearch("call_think_log_201810")
                .setTypes("call_think_log");
    }

    @Test
    public void matchAllTest() {
        SearchResponse searchResponse = searchRequestBuilder.setQuery(matchAllQuery()).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        searchHits.forEach(hit -> {
            System.out.println(hit.getSourceAsString());
        });
    }

    @Test
    public void emptySearchTest() {
        SearchResponse searchResponse = searchRequestBuilder.setQuery(matchAllQuery()).setFrom(10)
                .setSize(5).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        searchHits.forEach(hit -> {
            System.out.println(hit.getSourceAsString());
        });
    }

    @Test
    public void constantScoreTest() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(QueryBuilders.constantScoreQuery(QueryBuilders
                        .termQuery("cus_phone", "13882314639")).boost(2.0f))
                .build();
        searchRequestBuilder.setQuery(searchQuery.getQuery());
        System.out.println(searchRequestBuilder.toString());
    }

    @Test
    public void pageQueryFromSizeTest() {
        SearchResponse searchResponse = searchRequestBuilder.setQuery(matchAllQuery())
                .setFrom(10).setSize(5).execute().actionGet();
        SearchHits searchHits = searchResponse.getHits();
        searchHits.forEach(hit -> {
            System.out.println(hit.getSourceAsString());
        });
    }

    @Test
    public void scrollScanTest() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(QueryBuilders.constantScoreQuery(QueryBuilders
                        .termQuery("call_type", "1")))
                .build();
        Page<CallThinkLog> callThinkLogs = elasticsearchTemplate
                .startScroll(5000L, searchQuery, CallThinkLog.class);

        callThinkLogs.forEach(callThinkLog -> System.out.println(callThinkLog.toString()));
        String scrollId = ((AggregatedPageImpl) callThinkLogs).getScrollId();
        System.out.println(((AggregatedPageImpl) callThinkLogs).getTotalElements());
        int total = callThinkLogs.getContent().size();
        while (callThinkLogs.getContent().size() > 0) {
            callThinkLogs = elasticsearchTemplate.continueScroll(scrollId, 5000L, CallThinkLog.class);
            callThinkLogs.forEach(callThinkLog -> System.out.println(callThinkLog.toString()));
            total += callThinkLogs.getContent().size();
        }
        System.out.println("总遍历条数：" + total);
    }

    @Test
    public void termTest() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(QueryBuilders
                        .termQuery("cus_phone", "13882314639"))
                .build();
        searchRequestBuilder.setQuery(searchQuery.getQuery());
        System.out.println(searchRequestBuilder.toString());
    }

    @Test
    public void termsTest() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(QueryBuilders
                        .termsQuery("cus_phone", "13882314639","15532589612"))
                .build();
        searchRequestBuilder.setQuery(searchQuery.getQuery());
        System.out.println(searchRequestBuilder.toString());
    }

    @Test
    public void boolTest() {
        QueryBuilder qb = QueryBuilders.boolQuery()
                .must(QueryBuilders.boolQuery()
                        .should(QueryBuilders.matchQuery("cus_phone", "13882314639"))
                        .should(QueryBuilders.matchQuery("call_type", "1"))
                );

        searchRequestBuilder.setQuery(qb);
        System.out.println(searchRequestBuilder.toString());
    }

    @Test
    public void rangeTest() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder().
                withQuery(QueryBuilders.constantScoreQuery(QueryBuilders
                        .termQuery("cus_phone", "13882314639")).boost(2.0f))
                .build();
        searchRequestBuilder.setQuery(searchQuery.getQuery());
        System.out.println(searchRequestBuilder.toString());
    }
}
