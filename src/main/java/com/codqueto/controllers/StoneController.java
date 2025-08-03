package com.codqueto.controllers;

import com.codqueto.models.PowerStone;
import com.codqueto.models.Stone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoneController {

    private final Stone stone;

    @Autowired
    public StoneController(@Qualifier("power") Stone stone) {
        this.stone = stone;
    }

    @GetMapping()
    public PowerStone getPowerStone() {
        return (PowerStone) this.stone;
    }
}
