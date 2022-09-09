package com.co.lineadevida.apirest.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

public class Enterprise {

    @Setter @Getter
    private long idEnterprise;

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String document;

    @Setter @Getter
    private String Phone;

    @Setter @Getter
    private String address;

   /* @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    User[] users;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "idTransaction")
    Transaction[] transactions;*/

    @Setter @Getter
    private Date createdAt ;

    @Setter @Getter
    private Date updateAt;

}
