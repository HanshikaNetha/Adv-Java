package org.example.anno;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("msg")
@Qualifier("email")
public class EmailNotification implements NotificationServic{
    @Override
    public void send(String message){
        System.out.println("Email sent: "+message);
    }
}
