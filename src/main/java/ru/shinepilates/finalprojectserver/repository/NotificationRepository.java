package ru.shinepilates.finalprojectserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shinepilates.finalprojectserver.entity.NotificationEntity;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
}
