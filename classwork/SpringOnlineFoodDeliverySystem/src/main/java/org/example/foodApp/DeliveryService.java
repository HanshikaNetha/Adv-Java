package org.example.foodApp;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeliveryService {
    public DeliveryService(){
        System.out.println("Deliveryservucce bean created");
    }
    @PostConstruct
    public void init(){
        System.out.println("Delivery service ready");
    }
    @PreDestroy
    public void destory(){
        System.out.println("delivery service destroyed");
    }
    public void deliveryOrder(){
        System.out.println("order delivered successfully");
    }
}
