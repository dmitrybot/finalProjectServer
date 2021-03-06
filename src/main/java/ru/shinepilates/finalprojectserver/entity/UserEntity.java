package ru.shinepilates.finalprojectserver.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<NotificationEntity> notifications;
}
