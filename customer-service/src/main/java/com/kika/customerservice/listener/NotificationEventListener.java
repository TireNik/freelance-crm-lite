package com.kika.customerservice.listener;

import com.kika.customerservice.dto.CustomerCreatedEvent;
import com.kika.customerservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {

    private final NotificationService notificationService;

    @Async
    @TransactionalEventListener
    public void handleCustomerCreated(CustomerCreatedEvent event) {
        notificationService.sendWelcomeTaskAsync(event.getCustomerId());
    }
}
