package org.example.anno;

import org.springframework.stereotype.Component;

@Component
public class PushNotification implements NotificationServic{
    @Override
    public void send(String message){
        System.out.println("Notification poped: "+message);
    }
}
