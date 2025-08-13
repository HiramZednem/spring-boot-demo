package com.codqueto.services;

import com.codqueto.models.MindStone;
import com.codqueto.models.PowerStone;
import com.codqueto.models.RealityStone;
import com.codqueto.models.SoulStone;
import com.codqueto.models.SpaceStone;
import com.codqueto.models.Stone;
import com.codqueto.models.TimeStone;
import com.codqueto.utils.AvengerNotifier;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

@Service
@Slf4j
@Getter
@ConditionalOnBean(value = {
        MindStone.class,
        PowerStone.class,
        RealityStone.class,
        SoulStone.class,
        SpaceStone.class,
        TimeStone.class
})
public class GauntletServiceImpl implements GauntletService {

    private final Stone mindStone;
    private final Stone powerStone;
    private final Stone realityStone;
    private final Stone soulStone;
    private final Stone spaceStone;
    private final Stone timeStone;


    @PostConstruct
    public void init() {
        AvengerNotifier.sendNotification(this.getClass());
    }

    @Autowired
    public GauntletServiceImpl(
            @Qualifier("mind") Stone mindStone,
            @Qualifier("power") Stone powerStone,
            @Qualifier("reality") Stone realityStone,
            @Qualifier("soul") Stone soulStone,
            @Qualifier("space") Stone spaceStone,
            @Qualifier("time") Stone timeStone
    ) {
        this.mindStone = mindStone;
        this.powerStone = powerStone;
        this.realityStone = realityStone;
        this.soulStone = soulStone;
        this.spaceStone = spaceStone;
        this.timeStone = timeStone;
    }

    @Override
    public void useGauntlet(String stoneName) {
        switch (stoneName) {
            case "mind" -> log.info("Use stone: " + this.mindStone);
            case "power" -> log.info("use stone: " + this.powerStone);
            case "reality" -> log.info("Use stone: " + this.realityStone);
            case "soul" -> log.info("Use stone: " + this.soulStone);
            case "space" -> log.info("Use stone: " + this.spaceStone);
            case "time" -> log.info("Use stone: " + this.timeStone);
            default -> throw new IllegalArgumentException("Invalid Name");
        }

    }

    @Override
    public void useFullPower() {
        if (
                this.mindStone != null &&
                this.powerStone != null &&
                this.realityStone != null &&
                this.soulStone != null &&
                this.spaceStone != null &&
                this.timeStone != null
        ) {
            log.info("using all power");
        } else {
            throw new IllegalStateException("You need to have all the stones to use full power");
        }

    }

    public void setStones(Map<String, Stone> stones) {
        stones.forEach((fieldName, stone) -> {
            try {
                Field field = this.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(this, stone);
                log.info("Dependency Inyection of " + fieldName);
                field.setAccessible(false);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        final var stones = applicationContext.getBeanNamesForType(Stone.class);

        log.info("Beans loaded: {}", Arrays.toString(stones));
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("Gauntlet located at: {}", environment.getProperty("location"));
    }
}