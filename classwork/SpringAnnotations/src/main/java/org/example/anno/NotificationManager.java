package org.example.anno;

import org.example.annotations.EmailService;
import org.example.annotations.NotificationService;
import org.example.annotations.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationManager {

    private NotificationServic emailNotification;
    private NotificationServic pushNotification;
    private NotificationServic smsNotification;

    @Autowired
    public  NotificationManager(@Qualifier("msg") NotificationServic emailNotification, NotificationServic pushNotification, NotificationServic smsNotification){
        this.emailNotification=emailNotification;
        this.pushNotification=pushNotification;
        this.smsNotification=smsNotification;
    }
    public void notif(){
        System.out.println("@Primary for SMS");
        pushNotification.send("Helo via PRimary sms");
        emailNotification.send("gui");
    }
}
