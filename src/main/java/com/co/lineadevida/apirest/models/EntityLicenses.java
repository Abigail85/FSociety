package com.co.lineadevida.apirest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "licenses")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class EntityLicenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idLicenses", nullable = false)
    private Long idpermisos;

    @Column(name = "save")
    private Boolean save;

    @Column(name = "finbyall")
    private Boolean writing;

    @Column(name = "update")
    private Boolean update;

    @Column(name = "delete")
    private Boolean delete;

    @JoinColumn(name = "idEmployee",referencedColumnName = "idEmployee")
    @ManyToOne  (optional = false)
    private EntityEmployee idEmployee;


    public EntityLicenses(boolean save, boolean writing, boolean update, boolean delete, EntityEmployee employee) {
    }
}