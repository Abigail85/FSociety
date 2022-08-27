package com.co.lineadevida.apirest.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor(access = AccessLevel.PROTECTED)

public class Profile {

    @Getter @Setter
    private String id;

    @Getter @Setter
    private String image;

    @Getter @Setter
    private String phone;

    User user;

    @Getter @Setter
    private Date createdAt;

    @Getter @Setter
    private Date updateAt;

}
