package com.co.lineadevida.apirest.models;

import lombok.Data;

@Data
public class User {

    private String firstName;

    private String lastName;

    private Integer document;

    private String password;


}
