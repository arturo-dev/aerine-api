package com.arturo.aerineapi.game.build;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.stereotype.Service;

@Service
public class BuildServiceImpl implements BuildService {

    @Override
    public Collection<Build> defaultBuilds() {

        return Arrays.asList(
            Build.builder().level(0).type(BuildType.CASTLE).build(),
            Build.builder().level(0).type(BuildType.BLACKSMITH).build(),
            Build.builder().level(0).type(BuildType.FARM).build()
        );
    }
}