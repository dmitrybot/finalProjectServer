package ru.shinepilates.finalprojectserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.shinepilates.finalprojectserver.entity.NotificationEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationModel {

    private Long id;

    private String maintext;
    private String date;
    private boolean posted;

    public static NotificationModel toModel(NotificationEntity notificationEntity){
        NotificationModel model = new NotificationModel(notificationEntity.getId(), notificationEntity.getMaintext(), notificationEntity.getDate(), notificationEntity.getPosted());
        return model;
    }
}
