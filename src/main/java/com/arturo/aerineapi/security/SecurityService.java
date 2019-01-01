package com.arturo.aerineapi.security;

import org.springframework.security.core.Authentication;

public interface SecurityService {

    Authentication getAuth();

}