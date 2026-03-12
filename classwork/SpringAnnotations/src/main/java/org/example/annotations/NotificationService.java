package org.example.annotations;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public void notif(){
        System.out.println("Notification sent");
    }



}
