package com.arturo.aerineapi.security.operation;

import java.lang.reflect.Field;
import java.util.Arrays;

import com.arturo.aerineapi.common.constant.Key;
import com.arturo.aerineapi.exception.ExceptionRest;
import com.arturo.aerineapi.security.SecurityService;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OperationControlAspect {

    private static final Logger logger = LoggerFactory.getLogger(OperationControlAspect.class);

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private SecurityService securityService;

    @Around("@annotation(OperationSecure)")
    public Object secure(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Executing operation secure on {}", joinPoint.getArgs()[0].getClass());
        
        Object target = joinPoint.getArgs()[0];
        Field field = target.getClass().getDeclaredField("id");
        field.setAccessible(true);

        ObjectId id = (ObjectId) field.get(target);
        ObjectId userId = new ObjectId(securityService.getAuth().getName());
        Operation operation = operationRepository.findOne(userId);

        if (operation == null) {
            throw new ExceptionRest(HttpStatus.NON_AUTHORITATIVE_INFORMATION, Key.Security.OPERATION_NOT_SECURE);
        }

        logger.info("Securing operation {} on {}", id, operation.getId());
        
        if (operation != null && operation.getAlloweds() != null) {
            operation.getAlloweds().add(id);
        } else if (operation != null) {
            operation.setAlloweds(Arrays.asList(id));
        }

        operationRepository.save(operation);
    
        logger.info("Operation secure {} on {}", id, userId);

        return joinPoint.proceed();
    }

    @Around("@annotation(OperationControl)")
    public Object allowed(ProceedingJoinPoint joinPoint) throws Throwable, UnauthorizedUserException {
        logger.info("Executing operation control on {}", joinPoint.getArgs()[0].getClass());

        Object target = joinPoint.getArgs()[0];
        Field field = target.getClass().getDeclaredField("id");
        field.setAccessible(true);
        ObjectId id = (ObjectId) field.get(target);
        Boolean allowed = operationRepository.existsByIdAndAlloweds(new ObjectId(securityService.getAuth().getName()), id);

        logger.info("Operation control {}", allowed);
        if (!allowed) {
            throw new ExceptionRest(HttpStatus.METHOD_NOT_ALLOWED, "User.NotAllowed");
        }

        return joinPoint.proceed();
    }

}