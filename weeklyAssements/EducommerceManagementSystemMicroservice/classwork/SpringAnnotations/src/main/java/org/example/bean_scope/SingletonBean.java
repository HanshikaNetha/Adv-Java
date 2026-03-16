package org.example.bean_scope;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {
    public void sdis(){
        System.out.println("this is a singleton bean");
    }
}
