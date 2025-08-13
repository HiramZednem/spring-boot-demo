package com.codqueto.utils;

import com.codqueto.components.Thanos;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AvengerNotifier {

    public static void sendNotification(Class<?> clazz) {
        log.warn("Attention new class created: {}", clazz.getName());

        if(clazz.equals(Thanos.class)) {
            log.warn("Danger start battle!!!");
        }
    }
}
