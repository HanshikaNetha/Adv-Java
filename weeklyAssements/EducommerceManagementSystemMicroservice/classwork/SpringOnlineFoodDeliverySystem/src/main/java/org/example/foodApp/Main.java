package org.example.foodApp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FoodConfig.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();
        context.close();
    }
}
