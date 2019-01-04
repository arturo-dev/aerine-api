package com.arturo.aerineapi.game.server;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.arturo.aerineapi.game.map.MapService;

@Component
public class ServerInitializer implements InitializingBean {

    @Autowired
    private ServerRepository serverRepository;
    
    @Autowired
    private MapService mapService;

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
                        .map(mapService.generateNewMap())
                        .build()
                );
            }
        });
    }

}