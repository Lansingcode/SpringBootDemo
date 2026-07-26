package org.example.springbootredis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 运行前需启动本地redis服务：
 * brew services start redis
 * 关闭redis服务：
 * brew services stop redis
 */
@SpringBootTest
class SpringbootRedisApplicationTests {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void  testSet(){
        redisTemplate.boundValueOps("name").set("zhangsan");
    }

    @Test
    public  void testGet(){
        String name = (String) redisTemplate.boundValueOps("name").get();
        System.out.println(name);
    }


}
