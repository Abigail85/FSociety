package com.co.lineadevida.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "profile")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntityProfile {

    @Id
    @Column(name = "idProfile", nullable = false)
    private Long idProfile ;

    @Column(name = "imageProfile",nullable = true)
    private String imageProfile;

    @Column(name = "phoneProfile",nullable = true)
    private String phoneProfile;

    @Column(name = "createdAtProfile", nullable = false)
    private LocalDate createdAtProfile ;

    @Column(name = "updateAtProfile", nullable = true)
    private LocalDate updateAtProfile ;

    private String mensaje;
    @JoinColumn (name = "idEmployee", referencedColumnName = "idEmployee")
    @OneToOne    (optional = false)
    private EntityEmployee idEmployee ;


}