package com.company;


import java.awt.*;

public abstract class Creature {

    //Name of neighboring on the gird.
    public enum Neighboring {
        SAME, OTHER, WALL, FOOD, EMPTY
    }

    //Direction, this is which direction object will do next step.
    public enum Direction {
        N, S, W, E, STATIC
    }

    public enum PlaceInFoodChain{
        PLANT(1), HERBIVORE(2), PREDATOR(3);
        private int code;
        PlaceInFoodChain(int code){
            this.code = code;
        }
        public int getCode(){ return code;}
    }

    private int health;
    private String shape;
    private Direction direction;
    Direction[] directions = Creature.Direction.values();

    public Creature(){
        this.direction = Direction.S;
    }


    @Override
    public abstract String toString();

    public abstract Color getColor();

    public abstract String getShape();

    public abstract Direction getDirection();

    public abstract PlaceInFoodChain getPlaceInFoodChain();

}
