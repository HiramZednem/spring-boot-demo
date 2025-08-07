package com.codqueto.configs;

import com.codqueto.models.MindStone;
import com.codqueto.models.PowerStone;
import com.codqueto.models.RealityStone;
import com.codqueto.models.SoulStone;
import com.codqueto.models.SpaceStone;
import com.codqueto.models.TimeStone;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySources({
        @PropertySource("classpath:/configs/mind_stone.properties"),
        @PropertySource("classpath:/configs/power_stone.properties"),
        @PropertySource("classpath:/configs/reality_stone.properties"),
        @PropertySource("classpath:/configs/soul_stone.properties"),
        @PropertySource("classpath:/configs/space_stone.properties"),
        @PropertySource("classpath:/configs/time_stone.properties"),
        @PropertySource("classpath:/configs/stone.properties"),
})
public class StonesConfigs {

    @Value("${stones.mind.color}")
    private String mindColor;
    @Value("${stones.mind.name}")
    private String mindName;
    @Value("${stones.mind.location}")
    private String mindLocation;
    @Value("${stones.mind.energy_level}")
    private Integer mindEnergy;


    @Bean("mind")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.mind.create",
            havingValue = "true"
    )
    public MindStone mindStone() {
        return new MindStone(mindColor, mindName, mindLocation, mindEnergy);
    }

    @Bean("power")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.power.create",
            havingValue = "true"
    )
    public PowerStone PowerStone() {
        return new PowerStone();
    }

    @Bean("reality")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.reality.create",
            havingValue = "true"
    )
    public RealityStone RealityStone() {
        return new RealityStone();
    }

    @Bean("soul")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.soul.create",
            havingValue = "true"
    )
    public SoulStone soulStone() {
        return new SoulStone();
    }

    @Bean("space")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.space.create",
            havingValue = "true"
    )
    public SpaceStone spaceStone() {
        return new SpaceStone();
    }

    @Bean("time")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.time.create",
            havingValue = "true"
    )
    public TimeStone timeStone() {
        return new TimeStone();
    }
}

