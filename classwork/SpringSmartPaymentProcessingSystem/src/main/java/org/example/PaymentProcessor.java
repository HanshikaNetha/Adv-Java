package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaymentProcessor {
    @Autowired
    private TransactionLogger transactionLogger;

    private PaymentService upiPayment;
    private  PaymentService creditCardPayment;
    @Autowired
    public PaymentProcessor(@Qualifier("upi") PaymentService upiPayment, PaymentService creditCardPayment){
        this.upiPayment=upiPayment;
        this.creditCardPayment=creditCardPayment;
    }
    public void pui(){
//        creditCardPayment.processPayment(45);
//        transactionLogger.gui();
        upiPayment.processPayment(76);
    }
}
