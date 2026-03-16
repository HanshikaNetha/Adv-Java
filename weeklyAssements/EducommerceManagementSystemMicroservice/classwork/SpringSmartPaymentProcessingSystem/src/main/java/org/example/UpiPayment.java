package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Qualifier("upi")
public class UpiPayment implements PaymentService{
    public UpiPayment(){
        System.out.println("Upi bean contructor");
    }
    @Override
    public void processPayment(double amount){
        System.out.println(amount+" is paid using upi");
    }
    @PostConstruct
    public void init(){
        System.out.println("upi bean initialized");
    }
    @PreDestroy
    public void destory(){
        System.out.println("upi bean destoryed");
    }
}
