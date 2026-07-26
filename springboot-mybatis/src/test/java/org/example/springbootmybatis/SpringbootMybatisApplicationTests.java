package org.example.springbootmybatis;

import org.example.springbootmybatis.domain.User;
import org.example.springbootmybatis.mapper.UserMapper;
import org.example.springbootmybatis.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @Test
    public void findAllTest() {
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

    @Test
    public void findAllTest2() {
        List<User> users = userXmlMapper.findAll();
        System.out.println(users);
    }

}
