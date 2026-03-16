package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        MessageService messageService = context.getBean(MessageService.class);
        MessageService messageService1=context.getBean(MessageService.class);
        System.out.println("hui");
        System.out.println(messageService);
        System.out.println(messageService1);
        System.out.println(messageService==messageService1);
        System.out.println();

        EmailService emailService=context.getBean(EmailService.class);
        System.out.println(emailService);
        EmailService emailService1=context.getBean(EmailService.class);
        System.out.println(emailService1);
        System.out.println(emailService1==emailService);
        System.out.println("false bacuase we changed the scope from default singleton to prototype in bean.xml");
        System.out.println();

        messageService.sendMessage();

        ((ClassPathXmlApplicationContext) context).close();
    }
}
