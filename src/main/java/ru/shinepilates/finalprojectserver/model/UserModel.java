package ru.shinepilates.finalprojectserver.model;

import lombok.*;
import ru.shinepilates.finalprojectserver.entity.UserEntity;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

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
    private String lastphone;

    public UserEntity ModelToEntity(){
        UserEntity u = new UserEntity();
        u.setPhone(phone);
        u.setFirstname(firstname);
        u.setSecondname(secondname);
        u.setLastname(lastname);
        u.setPassword(password);
        u.setEmail(email);
        u.setRole(role);
        u.setBirthdata(birthdata);
        u.setSex(sex);
        u.setId(id);
        return u;
    }

}