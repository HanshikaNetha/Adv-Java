package org.example.bean_LifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        System.out.println(1);
        AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        System.out.println(2);
        dbConnection d=context.getBean(dbConnection.class);
        d.executeQuery();
        System.out.println(3);
        context.close();
        System.out.println(4);
    }
}
