package org.muhikira.notificationservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationEventProducer {

    private static final String TOPIC = "notification-topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendNotificationEvent(Object event) {
        kafkaTemplate.send(TOPIC, event);
    }
}
