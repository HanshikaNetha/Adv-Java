package org.example.anno;

import org.springframework.stereotype.Component;

@Component
public interface NotificationServic {
    public void send(String message);
}
