package com.company;

import java.awt.*;

public class EcosystemUnit {

    public static enum Direction {
        NORTH, SOUTH, EAST, WEST;
    }


        private Color color;
        private String shape;

        public EcosystemUnit(){
            this.color = Color.GRAY;
            this.shape = "o";
        }

        public String getShape(){
            return this.shape;
        }

        public Color getColor(){ return this.color; }

        @Override
        public String toString() {
        return "Default";
    }
}
