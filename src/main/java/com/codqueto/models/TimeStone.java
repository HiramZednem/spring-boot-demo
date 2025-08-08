package com.codqueto.models;

import lombok.ToString;
import lombok.extern.java.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@Log
@ToString(callSuper = true)
public class TimeStone extends Stone{

    public TimeStone(String color, String name, String location, Integer energyLevel) {
        super(color, name, location, energyLevel);
    }

    @Override
    public void usePower() {
        System.out.println("Control time" + super.toString());
    }

}
