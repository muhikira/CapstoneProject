package org.muhikira.notificationservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import java.time.LocalDateTime

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notification_logs")
public  class NotificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    var recipient: String? = null
    var message: String? = null
    var type: String? = null // EMAIL, SMS, etc.
    var sentAt: LocalDateTime? = null

    override fun toString(): String {
        return "NotificationLog(id=$id, recipient=$recipient, message=$message, type=$type, sentAt=$sentAt)"
    }
}
