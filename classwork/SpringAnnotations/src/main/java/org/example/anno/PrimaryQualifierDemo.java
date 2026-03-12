package org.example.anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrimaryQualifierDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrimaryQualifierConfig.class);
        NotificationManager m = context.getBean(NotificationManager.class);
        m.notif();
        context.close();
    }
}
