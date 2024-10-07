package org.muhikira.notificationservice.model


import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Table
import org.springframework.data.annotation.Id
import java.time.LocalDateTime


@Entity
@Table(name = "notification_logs")
public class NotificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var recipient: String? = null
    var message: String? = null
    var type: String? = null // EMAIL, SMS, etc.
    var sentAt: LocalDateTime? = null

    override fun toString(): String {
        return "NotificationLog [id=$id, recipient=$recipient, message=$message, type=$type, sentAt=$sentAt]"
    }
}