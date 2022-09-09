package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class EntityTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idTransaction", nullable = false)
    private Long idTransaction;

    @Column(name = "concept", nullable = false)
    private String concept;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "createdAtTransaction", nullable = false)
    private LocalDate createdAtTransaction = LocalDate.now();

    @Column(name = "updateAtTransaction", nullable = true)
    private Date updateAtTransaction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "idEnterprise")
    EntityEnterprise enterprise;

}