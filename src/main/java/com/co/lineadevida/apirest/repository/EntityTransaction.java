package com.co.lineadevida.apirest.repository;

import com.co.lineadevida.apirest.util.Enum_RoleName;
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

    @JoinColumn (name = "idEnterprise", referencedColumnName = "idEnterprise")
    @ManyToOne (optional = false)
    private EntityEnterprise idEnterprise;

}