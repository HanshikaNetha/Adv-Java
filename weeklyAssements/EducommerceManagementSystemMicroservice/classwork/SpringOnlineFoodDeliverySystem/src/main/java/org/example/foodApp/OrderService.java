package org.example.foodApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private NotificationService notificationService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    public OrderService(@Qualifier("sms") NotificationService notificationService){
        this.notificationService=notificationService;
    }
    public void placeOrder(){
        System.out.println("order placed succesfully");
        restaurantService.prepareOrder();
        notificationService.sendNotification("your order is goin to come soon pla wait");
    }
}
