package com.company;

import java.awt.*;

public class Plant extends Creature {

    private final PlaceInFoodChain placeInFoodChain = PlaceInFoodChain.PLANT;

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public String getShape() {
        return "p";
    }

    @Override
    public Direction getDirection() {
        return Direction.STATIC;
    }

    @Override
    public PlaceInFoodChain getPlaceInFoodChain() {
        return placeInFoodChain;
    }
}
