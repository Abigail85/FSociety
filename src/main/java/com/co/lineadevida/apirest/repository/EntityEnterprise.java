package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "enterprise")
@Data
public class EntityEnterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idEnterprise", nullable = false)
    private Long idEnterprise;

    @Column(name = "nameEnterprise", nullable = false)
    private String nameEnterprise;

    @Column(name = "nroDocumentEnterprise", nullable = false)
    private String nroDocumentEnterprise;

    @Column(name = "phoneEnterprise", nullable = false)
    private String phoneEnterprise;

    @Column(name = "addressEnterprise", nullable = false)
    private String addressEnterprise;

    @Column(name = "createdAtEnterprise", nullable = false)
    private LocalDate createdAtEnterprise = LocalDate.now();

    @Column(name = "updateAtEnterprise", nullable = true)
    private Date updateAtEnterprise ;
}