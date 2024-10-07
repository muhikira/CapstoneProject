package org.muhikira.notificationservice.service;

import org.muhikira.notificationservice.model.NotificationRequest;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    // Send notification based on the request type
    public void sendNotification(NotificationRequest request) {
        // Determine the type of notification (Email, SMS, etc.)
        if ("EMAIL".equalsIgnoreCase(request.getType())) {
            sendEmail(request.getTo(), request.getMessage());
        } else if ("SMS".equalsIgnoreCase(request.getType())) {
            sendSms(request.getTo(), request.getMessage());
        }
        // Add more types (e.g., Slack, Push notifications) as needed
    }

    private void sendEmail(String to, String message) {
        System.out.println("Sending email to: " + to + " with message: " + message);
        // Here you would implement actual email sending logic
    }

    private void sendSms(String to, String message) {
        System.out.println("Sending SMS to: " + to + " with message: " + message);
        // Here you would implement actual SMS sending logic
    }
}