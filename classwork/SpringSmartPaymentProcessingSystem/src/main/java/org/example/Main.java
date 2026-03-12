package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
//        TransactionLogger t=context.getBean(TransactionLogger.class);
        PaymentProcessor p=context.getBean(PaymentProcessor.class);

        p.pui();
//        t.gui();
        PaymentProcessor p1=context.getBean(PaymentProcessor.class);
        p1.pui();
//        TransactionLogger t2=context.getBean(TransactionLogger.class);
//        t2.gui();
        context.close();
    }
}
