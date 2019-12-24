package com.company;

import java.awt.*;

public class EcosystemUnit {

        public static enum State{
            SPACE;
        }
        private Color color;
        private String shape;

        public EcosystemUnit(){
            this.color = Color.BLACK;
            this.shape = "o";
        }

        public String getShape(){
            return this.shape;
        }

    @Override
    public String toString() {
        return "o";
    }
}
