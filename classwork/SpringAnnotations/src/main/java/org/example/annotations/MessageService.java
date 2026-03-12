package org.example.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {
    //field injection
//    @Autowired
//    EmailService emailService;

    private EmailService emailService;
//    @Autowired
    private SmsService smsService;
//    @Autowired
    private  NotificationService notificationService;
    //constructor injection- if more than one dependency must use autowired annotation

    public MessageService(EmailService emailService, SmsService smsService, NotificationService notificationService){
        this.emailService=emailService;
        this.smsService=smsService;
        this.notificationService=notificationService;
    }

    public MessageService(EmailService emailService, SmsService smsService){
        this.emailService=emailService;
        this.smsService=smsService;
    }
    @Autowired
    public MessageService(EmailService emailService){
        this.emailService=emailService;
    }

    //setter injection
//    @Autowired
//    public void setMessageService(EmailService emailService){
//        this.emailService=emailService;
//    }
    public void sendMessage() {
        emailService.send();
        smsService.sendSms();
        notificationService.notif();
    }
}
