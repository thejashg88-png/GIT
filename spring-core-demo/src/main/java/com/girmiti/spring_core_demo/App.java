package com.girmiti.spring_core_demo;

import com.girmiti.spring_core_demo.config.AppConfig;
import com.girmiti.spring_core_demo.service.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = context.getBean(Car.class);
        car.drive();
    }
}