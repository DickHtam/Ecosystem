package com.company;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class EcosystemModel {

    // Variables that contain value of grid size.
    private int weight;
    private int height;
    private EcosystemUnit[][] grid;
    private Map<Integer, EcosystemUnit> units;



    public EcosystemModel(int weight, int height) {
        //initialisation size of grid.
        this.weight = weight;
        this.height = height;
        grid = new EcosystemUnit[weight][height];

        //fill the gird by default EcosystemUnit object.
        for (int i = 0; i < weight; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new EcosystemUnit();

            }

        }

    }

    // Fill the gird by units from other class.
    public void addUnit(int number, Class<? extends EcosystemUnit> unit) throws Exception {

        for (int i = 0; i < number; i++) {
            grid[ThreadLocalRandom.current().nextInt(0, this.weight)][ThreadLocalRandom.current().nextInt(0, this.height)]
                    = makeUnit (unit);

        }

    }
    //Create new units.
    @SuppressWarnings("unchecked")
    private EcosystemUnit makeUnit(Class critter) throws Exception {
        Constructor c = critter.getConstructors()[0];
            return (EcosystemUnit) c.newInstance();

    }


    public EcosystemUnit[][] getGird(){
        return this.grid;
    }

}
