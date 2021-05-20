package ru.shinepilates.finalprojectserver.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "treners")
public class TrenersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trenersname;
    private String trenerspos;
    private String trenersdescr;
}
