package org.example.Enterprise;

import org.springframework.stereotype.Component;

@Component
public interface DocumentProcessor {
    public void processDocument(String documentName);
}
