package org.example.LazyBean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LazyDemo {
    public static void main(String[] args){

        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(LazyConfig.class);
        System.out.println("cotainer creation");
        Lazybean l=context.getBean(Lazybean.class);
        EagerBean e=context.getBean(EagerBean.class);
        System.out.println("container started");
        EagerBean e1e=context.getBean(EagerBean.class);
//        l.start();
//        e.start();
        context.close();
        System.out.println("container cretaion ended");
    }
}
