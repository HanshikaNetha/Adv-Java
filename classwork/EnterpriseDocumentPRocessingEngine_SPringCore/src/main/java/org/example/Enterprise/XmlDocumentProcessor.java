package org.example.Enterprise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
@Scope("prototype")
@Qualifier("xml")
public class XmlDocumentProcessor implements DocumentProcessor{
    @Override
    public void processDocument(String documentName){
        System.out.println("xml processsing: "+documentName);
    }
}
