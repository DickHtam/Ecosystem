package com.company;

import java.awt.*;

public class Predator extends Animal{

    private final PlaceInFoodChain placeInFoodChain = PlaceInFoodChain.PREDATOR;

    @Override
    public String toString() {
        return "Pr";
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public String getShape() {
        return "pr";
    }

    @Override
    public PlaceInFoodChain getPlaceInFoodChain() {
        return placeInFoodChain;
    }
}
