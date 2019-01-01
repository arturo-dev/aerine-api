package com.arturo.aerineapi.user;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;
import lombok.Generated;

@Data
@Generated
public class Authority implements GrantedAuthority {
    
    private String role;

    public Authority() {}

    public Authority(String role) {
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}