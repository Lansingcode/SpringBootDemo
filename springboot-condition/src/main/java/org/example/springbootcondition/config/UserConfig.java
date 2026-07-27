package org.example.springbootcondition.config;

import org.example.springbootcondition.condition.ClassCondition;
import org.example.springbootcondition.condition.ConditionOnClass;
import org.example.springbootcondition.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
//    @Conditional(ClassCondition.class)
    @ConditionOnClass("redis.clients.jedis.Jedis")
    public User user() {
        return new User();
    }

    @Bean
    @ConditionalOnProperty(name="itcast",havingValue = "itheima")
    public User user2() {
        return new User();
    }
}
