package com.codqueto.services;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;

public interface GauntletService extends ApplicationContextAware, EnvironmentAware {

    void useGauntlet(String stoneName);

    void useFullPower();
}