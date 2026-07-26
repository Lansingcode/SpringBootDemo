package org.example.springbootinit.Controller;

import org.example.springbootinit.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${name}")
    public String name;

    @Autowired
    public Environment environment;

    @Autowired
    public Person person;

    @RequestMapping("/hello")
    public String sayHello(){
        System.out.println(environment.getProperty("person.age"));
        System.out.println(person.toString());
        return "hello "+name;

    }
}
