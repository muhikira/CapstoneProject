package org.muhikira.notificationservice.controller;

import org.muhikira.notificationservice.model.NotificationRequest;
import org.muhikira.notificationservice.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Endpoint to send a notification via REST API
    @PostMapping("/send")
    public String sendNotification(@RequestBody NotificationRequest request) {
        notificationService.sendNotification(request);
        return "Notification sent!";
    }
}