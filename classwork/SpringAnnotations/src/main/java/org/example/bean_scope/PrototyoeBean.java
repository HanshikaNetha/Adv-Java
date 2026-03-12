package org.example.bean_scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PrototyoeBean {
    public void pdis(){
        System.out.println("prototype bean" );
    }
}
