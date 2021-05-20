package ru.shinepilates.finalprojectserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shinepilates.finalprojectserver.entity.NewsEntity;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
}