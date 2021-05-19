package ru.shinepilates.finalprojectserver.model;

import lombok.*;
import ru.shinepilates.finalprojectserver.entity.NotificationEntity;
import ru.shinepilates.finalprojectserver.entity.UserEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModelReturn {

    private Long id;

    private String firstname;
    private String secondname;
    private String lastname;
    private String password;
    private String email;
    private String phone;
    private int role;
    private String birthdata;
    private String sex;

    private List<NotificationModel> notifications;

    public static UserModelReturn toModel(UserEntity u){
        UserModelReturn model = new UserModelReturn();
        try{
            model.setId(u.getId());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setFirstname(u.getFirstname());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setSecondname(u.getSecondname());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setLastname(u.getLastname());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setPassword(u.getPassword());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setEmail(u.getEmail());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setPhone(u.getPhone());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setRole(u.getRole());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setBirthdata(u.getBirthdata());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setSex(u.getSex());
        } catch (Exception e){
            e.printStackTrace();
        }
        try{
            model.setNotifications(u.getNotifications().stream().map(NotificationModel::toModel).collect(Collectors.toList()));
        } catch (Exception e){
            e.printStackTrace();
        }
        return model;
    }
}
