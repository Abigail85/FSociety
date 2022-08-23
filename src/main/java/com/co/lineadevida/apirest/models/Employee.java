package com.co.lineadevida.apirest.models;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Employee {

    @Getter @Setter
    private long id;

    @Getter @Setter
    private String email;

    //@Getter @Setter
    //Profile profile;

    @Getter @Setter
    Enum_RoleName role;

    //@Getter @Setter
    //Enterprise enterprise;

    //@Getter @Setter
    //Transactions [] transactions;

    @Getter @Setter
    private Date updateAt ;

    @Getter @Setter
    private Date createdAt ;






}
