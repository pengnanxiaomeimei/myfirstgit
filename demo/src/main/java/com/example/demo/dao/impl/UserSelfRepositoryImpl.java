package com.example.demo.dao.impl;

import com.example.demo.dao.UserSelfRepository;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import javax.lang.model.element.VariableElement;

import static org.elasticsearch.index.query.QueryBuilders.*;

import java.util.Map;

/**
 * @Description:
 * @Author:cdd
 * @CreateDate:
 * @UpdateDate:
 */
@Repository
public class UserSelfRepositoryImpl implements UserSelfRepository {
    @Autowired
    ElasticsearchTemplate template;
    @Override
    public Map<String,Aggregation> findByNameLikeAndAggregations(String like) {
        SearchQuery query=new NativeSearchQueryBuilder()
                .withQuery(wildcardQuery("name",like))
                .addAggregation(AggregationBuilders.avg("result").field("age"))
                .build();
        Aggregations query1 = template.query(query, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse searchResponse) {
                Aggregations aggregations = searchResponse.getAggregations();
                return aggregations;
            }
        });
        Map<String, Aggregation> asMap = query1.getAsMap();
        System.out.println(asMap);
        return asMap;
    }
}
