package com.codqueto.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "thanos.config")
@AllArgsConstructor
@NoArgsConstructor
@Data // ToString, equales, getter, setter and hashcode
public class ThanosModel {
    private String planet;
    private String galaxy;
    private Integer defaultDestructionlevel;
}
