package ru.shinepilates.finalprojectserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.shinepilates.finalprojectserver.entity.NotificationEntity;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;
import ru.shinepilates.finalprojectserver.entity.UserEntity;
import ru.shinepilates.finalprojectserver.repository.NotificationRepository;
import ru.shinepilates.finalprojectserver.repository.UsersRepository;

import javax.management.NotificationEmitter;
import java.util.Optional;

@Service
public class NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UsersRepository usersRepository;

    public NotificationEntity createNotification(NotificationEntity notification, Long userId){
        UserEntity user = usersRepository.findById(userId).get();
        notification.setUser(user);
        return notificationRepository.save(notification);
    }

    public NotificationEntity update(Long id){
        NotificationEntity notification = notificationRepository.findById(id).get();
        notification.setPosted(!notification.getPosted());
        return notificationRepository.save(notification);
    }

    public void deleteNotification(NotificationEntity notification){
        for (NotificationEntity n: notificationRepository.findAll()){
            if (n.getId() == notification.getId()){
                notificationRepository.delete(n);
            }
        }
    }
}
