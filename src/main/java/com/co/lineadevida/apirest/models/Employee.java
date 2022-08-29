package com.co.lineadevida.apirest.models;

import com.co.lineadevida.apirest.util.Enum_RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.util.Date;
/*
 * cuando envios datos el json no tome ese dato @JsonIgnore
 * hacer la anotacion de que es una llave foranea  @JoinColumn (name = "llave foranea")
 * anotacion uno a muchos  @ManyToOne
 * anotacion uno a uno @OneToOne

*/

public class Employee extends User {

    @Getter @Setter
    private long idEmployee;

    @Getter @Setter
    private String email;

    @JsonIgnore
    @OneToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "idProfile")
    Profile profile;

    @Getter @Setter
    Enum_RoleName role;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "idEnterprise")
    Enterprise enterprise;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "idTransaction")
    Transaction [] transactions;

    @Getter @Setter
    private Date updateAt ;

    @Getter @Setter
    private Date createdAt ;

}
