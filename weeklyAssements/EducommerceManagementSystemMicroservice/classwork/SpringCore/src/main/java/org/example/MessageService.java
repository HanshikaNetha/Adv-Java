package org.example;

public class MessageService {
    private EmailService emailService;

    public MessageService(EmailService emailService){
        this.emailService=emailService;
    }
//    public EmailService getEmailService() {
//        return emailService;
//    }
//
//    public void setEmailService(EmailService emailService) {
//        this.emailService = emailService;
//    }
    public void init(){
        System.out.println("MEssageService bean is initialized");
    }
    public void destro(){
        System.out.println("messageservice bean destroyed");
    }
    public void sendMessage(){
        emailService.send();
    }
}
