package org.example.foodApp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Qualifier("sms")
public class SmsNotification implements NotificationService{
    public SmsNotification(){
        System.out.println("Sms bean created");
    }
    @Override
    public void sendNotification(String message){
        System.out.println("sms sent: "+message);
    }
}
