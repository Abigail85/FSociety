package com.co.lineadevida.apirest.models;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntityEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idEmployee", nullable = false)
    private Long idEmployee;

    @Column(name = "nameEmployee", nullable = false)
    private String nameEmployee;

    @Column(name = "lastNameEmployee", nullable = false)
    private String lastNameEmployee;

    @Column(name = "nroDocumentEmployee", nullable = false)
    private String nroDocumentEmployee;

    @Column(name = "emailEmployee", nullable = false)
    private String emailEmployee;

    @Column(name = "name_role")
    Enum_RoleName role;

    @Column(name = "createdAtEmployee", nullable = true)
    private LocalDate createdAtEmployee;

    @Column(name = "updateAtEmployee")
    private LocalDate updateAtEmployee;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idEmployee")
    private Collection<EntityLicenses> permisosCollection;


    @ManyToOne  (optional = false)
    @JoinColumn(name = "idEnterprise",referencedColumnName = "idEnterprise")
    private EntityEnterprise idEnterprise;

    @JsonIgnore
    @OneToOne (cascade = CascadeType.ALL, mappedBy = "idEmployee")
    EntityProfile idProfile;

}

