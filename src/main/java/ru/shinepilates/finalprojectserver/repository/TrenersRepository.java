package ru.shinepilates.finalprojectserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;
import ru.shinepilates.finalprojectserver.entity.TrenersEntity;

public interface TrenersRepository extends JpaRepository<TrenersEntity, Long> {
}