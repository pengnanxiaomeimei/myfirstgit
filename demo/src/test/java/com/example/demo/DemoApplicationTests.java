package com.example.demo;

import com.example.demo.dao.UserRepositories;
import com.example.demo.dao.UserSelfRepository;
import com.example.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    UserRepositories userRepositories;
    @Test
    public void contextLoads() {
        Iterable<User> all = userRepositories.findAll();
        all.forEach(s-> System.out.println(s));
    }
    @Test
    public void test(){

        userRepositories.save(new User("7","小阿郎",18,"15837142234"));
       /* ArrayList<User> users = new ArrayList<>();
        users.add(new User("2","简自豪",21,"13726553426"));
        users.add(new User("3","李元浩",22,"13864536475"));
        users.add(new User("4","阿让",23,"13765536254"));
        users.add(new User("5","麻辣香锅",24,"17736254635"));
        users.add(new User("6","史森明",19,"13654352436"));*/
        /*userRepositories.saveAll(users);*/
    }
    @Test
    public void test01(){
        List<User> containing = userRepositories.findByNameLike("阿里郎");
        for (User user : containing) {
            System.out.println(user);
        }
    }
    @Test
    public void testes(){
        List<User> byNameContaining = userRepositories.findByNameContaining("阿里郎");
        byNameContaining.forEach(s-> System.out.println(s));
    }
    @Test
    public void testes01(){
        List<User> byPhoneNumberContaining = userRepositories.findByPhoneNumberContaining("136");
        byPhoneNumberContaining.forEach(s-> System.out.println(s));
    }

    @Test
    public void test03(){
        List<User> byPhoneNumberBefore = userRepositories.findByPhoneNumberBefore("136");
        byPhoneNumberBefore.forEach(s-> System.out.println(s));
    }
    @Test
    public void test04(){
        List<User> byPhoneNumberStartsWith = userRepositories.findByPhoneNumberStartsWith("136");
        byPhoneNumberStartsWith.forEach(s-> System.out.println(s));
    }

    @Autowired
    UserSelfRepository userSelfRepository;
    @Test
    public void test05(){
        Map nameLikeAndAggregations = userSelfRepository.findByNameLikeAndAggregations("里");
        System.out.println(nameLikeAndAggregations);

    }

}
