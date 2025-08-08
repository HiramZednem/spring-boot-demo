package com.codqueto.configs;

import com.codqueto.models.MindStone;
import com.codqueto.models.PowerStone;
import com.codqueto.models.RealityStone;
import com.codqueto.models.SoulStone;
import com.codqueto.models.SpaceStone;
import com.codqueto.models.TimeStone;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
@Profile("movie")
@PropertySources({
        @PropertySource("classpath:/configs/mind_stone.properties"),
        @PropertySource("classpath:/configs/power_stone.properties"),
        @PropertySource("classpath:/configs/reality_stone.properties"),
        @PropertySource("classpath:/configs/soul_stone.properties"),
        @PropertySource("classpath:/configs/space_stone.properties"),
        @PropertySource("classpath:/configs/time_stone.properties"),
        @PropertySource("classpath:/configs/stone-movie.properties"),
})
public class StonesConfigsMovie {

    @Value("${subtitles.url}") private String subtitleUrl;
    @Value("${spring.profiles.active:default}") private String profile;

    @Value("${stones.mind.color}") private String mindColor;
    @Value("${stones.mind.name}") private String mindName;
    @Value("${stones.mind.location}") private String mindLocation;
    @Value("${stones.mind.energy_level}") private Integer mindEnergy;

    @PostConstruct()
    public void init() {
        log.info("Loading subtitles: {} profile: {}", this.subtitleUrl, this.profile);
    }
    @Bean("mind")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.mind.create",
            havingValue = "true"
    )
    public MindStone mindStone() {
        return new MindStone(mindColor, mindName, mindLocation, mindEnergy);
    }

    @Value("${stones.power.color}")
    private String powerColor;
    @Value("${stones.power.name}")
    private String powerName;
    @Value("${stones.power.location}")
    private String powerLocation;
    @Value("${stones.power.energy_level}")
    private Integer powerEnergy;

    @Bean("power")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.power.create",
            havingValue = "true"
    )
    public PowerStone PowerStone() {
        return new PowerStone(powerColor, powerName, powerLocation, powerEnergy);
    }

    @Value("${stones.reality.color}")
    private String realityColor;
    @Value("${stones.reality.name}")
    private String realityName;
    @Value("${stones.reality.location}")
    private String realityLocation;
    @Value("${stones.reality.energy_level}")
    private Integer realityEnergy;

    @Bean("reality")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.reality.create",
            havingValue = "true"
    )
    public RealityStone RealityStone() {
        return new RealityStone(realityColor,realityName,realityLocation,realityEnergy);
    }

    @Value("${stones.soul.color}")
    private String soulColor;
    @Value("${stones.soul.name}")
    private String soulName;
    @Value("${stones.soul.location}")
    private String soulLocation;
    @Value("${stones.soul.energy_level}")
    private Integer soulEnergy;

    @Bean("soul")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.soul.create",
            havingValue = "true"
    )
    public SoulStone soulStone() {
        return new SoulStone(soulColor,soulName,soulLocation,soulEnergy);
    }

    @Value("${stones.space.color}")
    private String spaceColor;
    @Value("${stones.space.name}")
    private String spaceName;
    @Value("${stones.space.location}")
    private String spaceLocation;
    @Value("${stones.space.energy_level}")
    private Integer spaceEnergy;

    @Bean("space")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.space.create",
            havingValue = "true"
    )
    public SpaceStone spaceStone() {
        return new SpaceStone(spaceColor,spaceName,spaceLocation,spaceEnergy);
    }

    @Value("${stones.time.color}")
    private String timeColor;
    @Value("${stones.time.name}")
    private String timeName;
    @Value("${stones.time.location}")
    private String timeLocation;
    @Value("${stones.time.energy_level}")
    private Integer timeEnergy;

    @Bean("time")
    @Scope("prototype")
    @ConditionalOnProperty(
            name = "stones.time.create",
            havingValue = "true"
    )
    public TimeStone timeStone() {
        return new TimeStone(timeColor,timeName,timeLocation,timeEnergy);
    }
}

