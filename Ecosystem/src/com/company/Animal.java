package com.company;

import java.awt.*;

public class Animal extends EcosystemUnit {

    private Color color;
    private String shape;

    public Animal(){
        this.color = Color.ORANGE;
        this.shape = "a";
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    public String getShape(){
        return this.shape;
    }

    @Override
    public String toString() {
        return "Plant";
    }
}
