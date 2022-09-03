package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class EntityEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Employee", nullable = false)
    private Long idEmployee;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "nro_document", nullable = false)
    private String nroDocument;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "name_role", nullable = false)
    Enum_RoleName role;

    @Column(name = "createdAt_employee", nullable = false)
    private LocalDate createdAt = LocalDate.now();

    @Column(name = "updateAt_employee", nullable = true)
    private Date updateAt ;



}