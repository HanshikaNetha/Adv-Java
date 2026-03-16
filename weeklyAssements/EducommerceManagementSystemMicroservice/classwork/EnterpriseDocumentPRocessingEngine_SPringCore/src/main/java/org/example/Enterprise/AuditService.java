package org.example.Enterprise;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class AuditService {
    @PostConstruct
    public void inti(){
        System.out.println("AuditService initialized");
    }
    @PreDestroy
    public void dsetoy(){
        System.out.println("AuditSercice destoryed");
    }
    public void log(String documentName){
        System.out.println("logging-> soon will start the processing: "+documentName);
    }
}
