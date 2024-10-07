package org.muhikira.notificationservice.model;

public class NotificationRequest {

    private String to;
    private String message;
    private String type; // EMAIL, SMS, etc.

    // Getters and Setters
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "NotificationRequest [to=" + to + ", message=" + message + ", type=" + type + "]";
    }
}