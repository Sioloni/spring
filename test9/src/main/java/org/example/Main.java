package org.example;

import org.example.config.SpringConfig;
import org.example.test.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext contextClassConfig =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        ApplicationContext contextXmlConfig =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        User user = contextClassConfig.getBean("user", User.class);
        System.out.println(user.toString());

        User user1 = contextXmlConfig.getBean("user1", User.class);
        System.out.println(user1.toString());


    }
}