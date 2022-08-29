package com.co.lineadevida.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Transaction {

    @Getter @Setter
    private long idTransaction;

    @Getter @Setter
    private String concept;

    @Getter @Setter
    private float amount;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEnterprise")
    Enterprise enterprise;

    @Getter @Setter
    Date createdAt;

    @Getter @Setter
    Date updateAt;


}
