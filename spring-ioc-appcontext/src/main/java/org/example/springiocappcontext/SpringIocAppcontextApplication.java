package org.example.springiocappcontext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringIocAppcontextApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIocAppcontextApplication.class, args);

        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            UserService userService = context.getBean(UserService.class);
            User user = userService.login("bob@example.com", "password");
            System.out.println("Logged in: " + user.getName());
        }
    }

}
