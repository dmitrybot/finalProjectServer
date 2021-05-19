package ru.shinepilates.finalprojectserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shinepilates.finalprojectserver.entity.NotificationEntity;
import ru.shinepilates.finalprojectserver.entity.ReportEntity;
import ru.shinepilates.finalprojectserver.model.NotificationModel;
import ru.shinepilates.finalprojectserver.service.NotificationService;
import ru.shinepilates.finalprojectserver.service.ReportService;

import java.util.List;

@RestController
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    /*
    @GetMapping("/notifications")
    public List<ReportEntity> getReports(){
        return reportService.getAllReports();
    }*/
    /*
    @PostMapping("/user")
    public UserEntity getUser(@RequestBody UserEntity user){
        return userService.authorisation(user);
    }
    */

    @PostMapping("/notifications/{userId}")
    public NotificationModel postNotification(@RequestBody NotificationEntity notification, @PathVariable Long userId) {
        try {
            return NotificationModel.toModel(notificationService.createNotification(notification, userId));
        } catch (Exception e) {
            NotificationModel model = new NotificationModel();
            model.setDate("wrong");
            return model;
        }
    }

    @DeleteMapping("/notifications")
    public void deleteNotification(@RequestBody NotificationEntity notification){
        notificationService.deleteNotification(notification);
    }

    @PutMapping("/notifications/{id}")
    public NotificationModel updateNotification(@PathVariable Long id){
        try{
            return NotificationModel.toModel(notificationService.update(id));
        } catch (Exception e){
            NotificationModel model = new NotificationModel();
            model.setDate("wrong");
            return model;
        }
    }

}
