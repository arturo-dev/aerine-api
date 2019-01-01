package com.arturo.aerineapi.config;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.mapping.context.PersistentEntities;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ValidatorEventListener extends ValidatingRepositoryEventListener {

    public ValidatorEventListener(ObjectFactory<PersistentEntities> persistentEntitiesFactory) {
        super(persistentEntitiesFactory);
    }
    
}