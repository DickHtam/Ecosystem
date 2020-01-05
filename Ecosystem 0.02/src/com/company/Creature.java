package com.company;


import java.awt.*;

public class Creature {

    private int health;
    private String shape;

    public Creature(){
        this.health = 10;
        this.shape = "c";
    }

    @Override
    public String toString() {
        return "CREA";
    }

    public Color getColor() {
        return Color.ORANGE;
    }

    public String getShape() {
        return this.shape;
    }

}
