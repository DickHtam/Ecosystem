package com.company;

import java.awt.*;

public class Plant extends EcosystemUnit {

    private Color color;
    private String shape;

    public Plant(){
        this.color = Color.GREEN;
        this.shape = "p";
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
