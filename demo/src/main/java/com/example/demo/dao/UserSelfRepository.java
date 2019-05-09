package com.example.demo.dao;

import java.util.Map;

/**
 * @Description:
 * @Author:cdd
 * @CreateDate:
 * @UpdateDate:
 */
public interface UserSelfRepository {
    Map findByNameLikeAndAggregations(String like);
}
