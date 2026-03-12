package org.example.LazyBean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class Lazybean {
    public Lazybean(){
        System.out.println("Lazy bean cerated");
    }
    public void start(){
        System.out.println("Lazt bean started");
    }
}
