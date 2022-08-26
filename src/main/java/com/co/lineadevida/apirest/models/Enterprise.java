package com.co.lineadevida.apirest.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Enterprise {

    @Setter @Getter
    private long id;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String document;
    @Setter @Getter
    private String Phone;
    @Setter @Getter
    private String address;

    //User[] users;

    //Transaction[] transactions;

    @Setter @Getter
    private Date createdAt;
    @Setter @Getter
    private Date updateAt;






}
