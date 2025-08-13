package com.codqueto.components;

import com.codqueto.models.ThanosModel;
import com.codqueto.services.GauntletService;
import com.codqueto.utils.AvengerNotifier;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*
* When using component the DI is automatically
* */
@Component
@AllArgsConstructor
@Slf4j
@ConditionalOnClass(value = Faker.class) // when we deppend to a 3d party library
public class Thanos {


    private final GauntletService gauntletService;
    private final ThanosModel thanosModel;

    @PostConstruct
    public void init() {
        log.info("initializating thanosModel: {}", this.thanosModel);
        AvengerNotifier.sendNotification(this.getClass());
    }

    @PreDestroy
    public void destroy() {
       log.warn("Battle end");
    }

    public void snap() {
        final var faker = new Faker();
        final var country = faker.country().name();

      log.info("Thanos is using the gauntlet to perform snap in {}", country);

      this.gauntletService.useFullPower();

      final var impactPoints = faker.random().nextInt(1000);

      log.info("Thaanos has made {} danger points", impactPoints);

    }

}
