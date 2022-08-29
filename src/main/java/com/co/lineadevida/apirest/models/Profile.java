package com.co.lineadevida.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;


public class Profile {

    @Getter @Setter
    private String idProfile;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String phone;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    User user;

    @Getter @Setter
    private Date createdAt;

    @Getter @Setter
    private Date updateAt;

}
