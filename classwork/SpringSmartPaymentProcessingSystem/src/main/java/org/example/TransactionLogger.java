package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TransactionLogger {
    private PaymentService creditCardPayment;
    private PaymentService upiPayment;
    public TransactionLogger(){

    }
    @Autowired
    public TransactionLogger(PaymentService creditCardPayment, PaymentService upiPayment){
        this.creditCardPayment=creditCardPayment;
        this.upiPayment=upiPayment;
    }

    @PostConstruct
    public void initMethod(){
        System.out.println("Logger initialized");
    }
    @PreDestroy
    public void destroyMethod(){
        System.out.println("Logger destryoed");
    }
    public void gui(){
        creditCardPayment.processPayment(56);
    }
}
