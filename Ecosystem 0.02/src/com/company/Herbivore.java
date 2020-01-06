package com.company;

import java.awt.*;

public class Herbivore extends Animal {


    private final PlaceInFoodChain placeInFoodChain = PlaceInFoodChain.HERBIVORE;

    @Override
    public String toString() {
        return "H";
    }

    @Override
    public Color getColor() {
        return Color.GRAY;
    }

    @Override
    public String getShape() {
        return "h";
    }

    @Override
    public PlaceInFoodChain getPlaceInFoodChain() {
        return placeInFoodChain;
    }
}
