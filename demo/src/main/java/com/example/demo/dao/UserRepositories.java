package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author:cdd
 * @CreateDate:
 * @UpdateDate:
 */
public interface UserRepositories extends ElasticsearchRepository<User,String> {
    public List<User> findByNameContaining(String contain);
    public List<User> findByNameLike(String like);
    public List<User> findByPhoneNumberContaining(String contain);
    public List<User> findByPhoneNumberBefore(String before);
    List<User> findByPhoneNumberStartsWith(String start);
}
