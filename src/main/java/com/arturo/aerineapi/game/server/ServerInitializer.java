package com.arturo.aerineapi.game.server;

import java.util.Collection;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServerInitializer implements InitializingBean {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private ServersList servers;


    @Override
    public void afterPropertiesSet() throws Exception {
        servers.getServers().forEach(serverName -> {
            if (serverRepository.findOneByName(serverName) == null) {
                serverRepository.save(
                    Server
                        .builder()
                        .name(serverName)
                        .build()
                );
            }
        });
    }

}