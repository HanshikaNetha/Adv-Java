package org.example.anno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SmsNotification implements NotificationServic{

    @Override
    public void send(String message){
        System.out.println("Sms sent: "+message);
    }
}
