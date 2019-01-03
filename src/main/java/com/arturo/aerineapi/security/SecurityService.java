package com.arturo.aerineapi.security;

import com.arturo.aerineapi.user.User;

import org.springframework.security.core.Authentication;

public interface SecurityService {

    Authentication getAuth();

    User getUser();

}