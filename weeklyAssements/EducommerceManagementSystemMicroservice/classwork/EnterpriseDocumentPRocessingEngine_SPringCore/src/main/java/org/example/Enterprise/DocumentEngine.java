package org.example.Enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.print.Doc;

@Component
public class DocumentEngine {
    private AuditService auditService;
    @Autowired
    private StorageService storageService;

    private DocumentProcessor documentProcessor;
    @Autowired
    public DocumentEngine(@Qualifier("xml") DocumentProcessor documentProcessor){
        this.documentProcessor=documentProcessor;
    }

    @Autowired
    public void setAuditService(AuditService auditService){
        this.auditService=auditService;
    }

    public void execute(String documentName){
        auditService.log(documentName);
        documentProcessor.processDocument(documentName);
        storageService.store(documentName);

    }
}
