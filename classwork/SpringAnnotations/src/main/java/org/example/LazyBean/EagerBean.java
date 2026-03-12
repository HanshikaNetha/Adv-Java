package org.example.LazyBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class EagerBean {
    public  EagerBean(){
        System.out.println("Eager bean created");
    }
    public void start(){
        System.out.println("Eagerbean started");
    }
}
