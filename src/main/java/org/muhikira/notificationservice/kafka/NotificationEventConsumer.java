package org.muhikira.notificationservice.kafka;

import org.muhikira.notificationservice.model.NotificationRequest;
import org.muhikira.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventConsumer {

    @Autowired
    private NotificationService notificationService;

    @KafkaListener(topics = "employee-topic", groupId = "hrms-group")
    public void consumeEmployeeEvent(String message) {
        // Example: Sending notification when an employee event is triggered
        NotificationRequest request = new NotificationRequest();
        request.setTo("hr@example.com");
        request.setMessage("Employee event occurred: " + message);
        request.setType("EMAIL");

        notificationService.sendNotification(request);
        System.out.println("Processed Employee Event for Notification: " + message);
    }

    @KafkaListener(topics = "payroll-topic", groupId = "hrms-group")
    public void consumePayrollEvent(String message) {
        // Example: Sending payroll-related notification
        NotificationRequest request = new NotificationRequest();
        request.setTo("employee@example.com");
        request.setMessage("Your payroll has been processed: " + message);
        request.setType("EMAIL");

        notificationService.sendNotification(request);
        System.out.println("Processed Payroll Event for Notification: " + message);
    }
}