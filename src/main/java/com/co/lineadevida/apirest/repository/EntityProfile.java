package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "profile")
@Data
public class EntityProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idProfile", nullable = false)
    private Long idProfile;

    @Column(name = "imageProfile", nullable = false)
    private String imageProfile;

    @Column(name = "phoneProfile", nullable = false)
    private String phoneProfile;

    @Column(name = "createdAtProfile", nullable = false)
    private LocalDate createdAtProfile = LocalDate.now();

    @Column(name = "updateAtProfile", nullable = true)
    private LocalDate updateAtProfile = LocalDate.now();
}