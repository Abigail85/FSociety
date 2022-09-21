package com.co.lineadevida.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class EntityTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idTransaction", nullable = false)
    private Long idTransaction;

    @Column(name = "concept", nullable = false)
    private String concept;

    private String mensaje;

    @Column(name = "amount", nullable = false)
    private Float amount;

    @Column(name = "createdAtTransaction", nullable = false)
    private LocalDate createdAtTransaction = LocalDate.now();

    @Column(name = "updateAtTransaction", nullable = true)
    private LocalDate updateAtTransaction;

    @ManyToOne  (optional = false)
    @JoinColumn(name = "idEnterprise",referencedColumnName = "idEnterprise")
    private EntityEnterprise idEnterprise;


}