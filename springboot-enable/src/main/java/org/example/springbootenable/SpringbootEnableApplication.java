package org.example.springbootenable;

import org.example.springbootenableother.config.EnableUser;
import org.example.springbootenableother.config.UserConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ComponentScan("org.example.springbootenableother.config")
//@Import(UserConfig.class)
@EnableUser
public class SpringbootEnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootEnableApplication.class, args);

        Object user = context.getBean("user");
        System.out.println(user);
    }

}
