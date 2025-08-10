package com.codqueto.configs;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(
        @PropertySource("classpath:/configs/thanos.properties")
)
@EnableConfigurationProperties
public class ThanosConfig {
}
