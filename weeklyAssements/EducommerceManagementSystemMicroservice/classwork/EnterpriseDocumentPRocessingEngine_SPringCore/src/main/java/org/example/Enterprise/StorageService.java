package org.example.Enterprise;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class StorageService {
    public void store(String documentName){
        System.out.println("storing: "+documentName);
    }
}
