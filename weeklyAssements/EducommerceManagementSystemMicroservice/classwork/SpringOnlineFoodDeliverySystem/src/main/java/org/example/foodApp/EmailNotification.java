package org.example.foodApp;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailNotification implements NotificationService{
    public EmailNotification(){
        System.out.println("Email bean created");
    }
    @Override
    public void sendNotification(String message){
        System.out.println("Email sent: "+message);
    }
}
