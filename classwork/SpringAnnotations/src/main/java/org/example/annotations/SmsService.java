package org.example.annotations;

import org.springframework.stereotype.Component;

@Component
public class SmsService {
    public void sendSms(){
        System.out.println("sms sent");
    }

}
