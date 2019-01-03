package com.arturo.aerineapi.game.server;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Generated;

@Component
@Data
@ConfigurationProperties(prefix = "game")
@Generated
public class ServersList {
    private List<String> servers;
}