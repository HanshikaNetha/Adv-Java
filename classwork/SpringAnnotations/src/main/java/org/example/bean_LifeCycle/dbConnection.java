package org.example.bean_LifeCycle;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class dbConnection {
    public  dbConnection(){
        System.out.println("dbConnection contructor called");
    }
    @PostConstruct
    public void initMethod(){
        System.out.println("dbConnection initializing");
    }
    @PreDestroy
    public void destroyMethod(){
        System.out.println("dbConnection is goin to destroy");
        System.out.println("called before objection destruction");
    }
    public void executeQuery(){
        System.out.println("Query is being executed");
    }
}
