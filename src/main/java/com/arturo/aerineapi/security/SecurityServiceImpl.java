package com.arturo.aerineapi.security;

import com.arturo.aerineapi.user.User;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {

    private static final Logger logger = LoggerFactory.getLogger(SecurityService.class);

    @Override
    public Authentication getAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        logger.info("Retrieving auth of {}", auth.getName());
        return auth;
    }

    @Override
    public User getUser() {
        return User.builder().id(new ObjectId(getAuth().getName())).build();
    }

}