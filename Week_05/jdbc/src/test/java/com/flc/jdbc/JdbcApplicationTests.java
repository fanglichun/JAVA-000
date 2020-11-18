package com.flc.jdbc;

import com.flc.bean.User;
import com.flc.jdbc.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class JdbcApplicationTests {

    @Autowired
    private UserDao userDao;


    @Test
    void contextLoads() {
//        jdbc();
        hikariData();
    }

    private void jdbc() {
        List<User> users = userDao.findAll();
        System.out.println(users);
        userDao.insert(User.builder().id(1).code("12345").name("flc").build());
        List<User> users1 = userDao.findAll();
        System.out.println(users1);
        userDao.update(User.builder().id(1).code("20103259").name("fanglc").build());
        List<User> users2 = userDao.findAll();
        System.out.println(users2);
        userDao.deleteAll();
        List<User> users3 = userDao.findAll();
        System.out.println(users3);
    }

    private void hikariData() {
        userDao.insert(User.builder().id(1).code("123457890").name("flc").build());
        List<User> users = userDao.selectAll();
        System.out.println(users);
    }
}
