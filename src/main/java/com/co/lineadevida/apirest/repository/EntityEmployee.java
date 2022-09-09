package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;


@Entity
@Table(name = "employee")
@Data
public class EntityEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column(name = "createdAtEmployee", nullable = false)
    private LocalDate createdAtEmployee = LocalDate.now();

    @Column(name = "updateAtEmployee")
    private LocalDate updateAtEmployee;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "idEmployee")
    private Collection<EntityLicenses> permisosCollection;


    @JoinColumn(name = "idEnterprise",referencedColumnName = "idEnterprise")
    @ManyToOne  (optional = false)
    private EntityEnterprise idEnterprise;

    @OneToOne (cascade = CascadeType.ALL, mappedBy = "idEmployee")
    private EntityProfile  profile;



    }

