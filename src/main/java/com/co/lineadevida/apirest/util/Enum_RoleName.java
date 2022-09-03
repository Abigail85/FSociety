package com.co.lineadevida.apirest.util;

import java.util.Arrays;

public enum Enum_RoleName {
    ROLE_ADMIN("Role admin","1"),
    ROLE_OPERARIO("Role operario","2"),
    DEFAULT("N/A","N/A");
    private final String roleName;
    private final String roleCode;
    Enum_RoleName(String roleName,String roleCode){
        this.roleName=roleName;
        this.roleCode=roleCode;
    }
    public String getRoleName(){return roleName;}
    public static String getRoleCode(String roleName){
        return Arrays.stream(values()).filter(trn ->trn.getRoleName().equalsIgnoreCase(roleName)).findFirst().orElse(DEFAULT).roleCode;
    }


}
