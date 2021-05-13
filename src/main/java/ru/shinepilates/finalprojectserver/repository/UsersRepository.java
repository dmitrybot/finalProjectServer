package ru.shinepilates.finalprojectserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.shinepilates.finalprojectserver.entity.UserEntity;

public interface UsersRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByPhone(String phone);
}