package org.example;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService{
    @Override
    public void processPayment(double amount){
        System.out.println(amount+" is paid using credit card payment");
    }
    public CreditCardPayment(){
        System.out.println("credit card contrustored");
    }
    @PostConstruct
    public void fu(){
        System.out.println("creditCardPayment initlaized");
    }
    @PreDestroy
    public void yu(){
        System.out.println("creditCardPayment destoyed");
    }
}
