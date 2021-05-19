package ru.shinepilates.finalprojectserver.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notificaations")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String maintext;
    private String date;
    private boolean posted;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public boolean getPosted(){
        return posted;
    }
}
