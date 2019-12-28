package com.company;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EcosystemModel {

    // Variables that contain value of grid size.
    private int width;
    private int height;
    private static int totalNumberOfUnits = 0;
    private EcosystemUnit[][] grid;



    public EcosystemModel(int width, int height) {
        //initialisation size of grid.
        this.width = width;
        this.height = height;
        grid = new EcosystemUnit[width][height];

        //fill the gird by default EcosystemUnit object.
//        for (int i = 0; i < width; i++) {
//            for (int j = 0; j < height; j++) {
//                grid[i][j] = new EcosystemUnit();
//
//            }
//
//        }

    }

    // Random fill the gird by units from other class.
    public EcosystemModel addUnit(int number, Class<? extends EcosystemUnit> unit) throws Exception {
        int randomH, randomW;
        //Calculate of units number.
        totalNumberOfUnits = totalNumberOfUnits + number;
        if(totalNumberOfUnits >= height * width) throw new RuntimeException("Too many units for this map.");
        for (int i = 0; i < number; i++) {
            randomW = ThreadLocalRandom.current().nextInt(0, this.width);
            randomH = ThreadLocalRandom.current().nextInt(0, this.height);

            /* !!! The code below very bad, need to reform !!! */
            if(grid[randomW][randomH] == null) grid[randomW][randomH] = makeUnit(unit); else i--;
        }
        return this;
    }
    //Create new units.
    private EcosystemUnit makeUnit(Class critter) throws Exception {
        Constructor c = critter.getConstructors()[0];
            return (EcosystemUnit) c.newInstance();

    }


    public EcosystemUnit[][] getGird(){
        return this.grid;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
