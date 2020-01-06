package com.company;

import java.awt.*;

public class Animal extends Creature {

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public String getShape() {
        return null;
    }

    @Override
    public Direction getDirection() {
        return directions[HelpMethods.getRandomValueInRange(0, 4)];
    }

    @Override
    public PlaceInFoodChain getPlaceInFoodChain() {
        return null;
    }
}
