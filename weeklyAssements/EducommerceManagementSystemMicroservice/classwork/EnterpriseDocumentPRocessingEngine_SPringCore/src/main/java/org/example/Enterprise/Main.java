package org.example.Enterprise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(EnterpriseConfig.class);
        DocumentEngine d=context.getBean(DocumentEngine.class);
        d.execute("hani.xml");
        context.close();

    }
}
