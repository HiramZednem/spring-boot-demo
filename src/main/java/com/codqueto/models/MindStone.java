package com.codqueto.models;

import com.codqueto.utils.AvengerNotifier;
import lombok.ToString;
import lombok.extern.java.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

@ToString(callSuper = true)
@Log
public class MindStone extends Stone{

    public MindStone(String color, String name, String location, Integer energyLevel) {
        super(color, name, location, energyLevel);
    }

    @Override
    public void usePower() {
        System.out.println("Mind control in stone: " + super.toString());
    }
}