package org.example;

import org.springframework.stereotype.Component;

@Component
public interface PaymentService {
    public void processPayment(double amount);
}
