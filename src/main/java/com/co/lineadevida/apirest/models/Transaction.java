package com.co.lineadevida.apirest.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Transaction {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String concept;

    @Getter @Setter
    private float amount;

    //User user;
    //Enterprise enterprise;
    @Getter @Setter
    Date createdAt;

    @Getter @Setter
    Date updateAt;


}
