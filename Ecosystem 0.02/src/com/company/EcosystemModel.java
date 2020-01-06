package com.company;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.HashMap;


public class EcosystemModel {

    //Name of neighboring on the gird.
//    public enum Creature.Neighboring {
//        SAME, OTHER, WALL, FOOD, EMPTY
//    }

//    //Direction, this is which direction object will do next step.
//    public enum Creature.Direction {
//        N, S, W, E, STATIC
//    }
    //Size of gird.
    public final static int WIDTH = 20, HEIGHT = 20;

    private int totalNumberOfCreature = 0;

    private HashMap<Creature, PrivateData> info;

    public Creature[][] gird;

    public static int exception = 0;

    public EcosystemModel() {
        this.gird = new Creature[WIDTH][HEIGHT];
        info = new HashMap<>();
    }

    //Data about object in the model. (Like direction, coordinates, etc.)
    public class PrivateData {
        public Point point;
        public Creature.Direction direction;

        public PrivateData(Point p, Creature.Direction d) {
            this.point = p;
            this.direction = d;
        }

        public Creature.Direction getDirection() {
            return this.direction;
        }

        public Point getPoint() {
            return this.point;
        }
    }

    //Add units int model and fill the gird.
    public void addUnits(int numberOfCreature, Class unit) {
        int randomW, randomH;
        Creature.Direction[] directions = Creature.Direction.values();
        for (int i = 0; i < numberOfCreature; i++) {
            do {
                randomW = HelpMethods.getRandomValueInRange(0, WIDTH);
                randomH = HelpMethods.getRandomValueInRange(0, HEIGHT);
//                        randomW = 7;
//                        randomH = 6;
            } while (gird[HelpMethods.getRandomValueInRange(0, WIDTH)][HelpMethods.getRandomValueInRange(0, HEIGHT)] != null);
            if(gird[randomW][randomH] == null) gird[randomW][randomH] = makeUnit(unit); else i--;

            Creature.Direction d = gird[randomW][randomH].getDirection();
            //Fill HashMap info.
            info.put(this.gird[randomW][randomH], new PrivateData(new Point(randomW, randomH), d));

        }
        this.totalNumberOfCreature = this.totalNumberOfCreature + numberOfCreature;
    }

    //Method which executes of moving for each object in the gird.
    public void step() {
        Object[] array = info.keySet().toArray();
        Point p;
        Point pH;

        for (int i = 0; i < array.length; i++) {
            if (typeAhead((Creature) array[i]) == Creature.Neighboring.EMPTY) {
                            p = info.get((Creature) array[i]).point;
                            pH = movePointToAhead((Creature) array[i]);
                            info.get((Creature) array[i]).point = pH;
                            gird[pH.x][pH.y] = gird[p.x][p.y];
                            gird[p.x][p.y] = null;
                        } else {

                                info.get(array[i]).direction = rightRotate(info.get(array[i]).direction);

                        }
        }
    }

    //Returns "Point" which contains coordinates "x" and "y", which are coordinates for the next proposed location.
    public Point movePointToAhead(Creature.Direction d, Point p) {
        if (d == Creature.Direction.N) return new Point(p.x, p.y - 1);
        if (d == Creature.Direction.E) return new Point(p.x + 1, p.y);
        if (d == Creature.Direction.S) return new Point(p.x, p.y + 1);
        if (d == Creature.Direction.W) return new Point(p.x - 1, p.y);
        else return p;
    }

    public Point movePointToAhead(Creature c) {
        Creature.Direction d = info.get(c).getDirection();
        Point p = info.get(c).getPoint();
        if (d == Creature.Direction.N) return new Point(p.x, p.y - 1);
        if (d == Creature.Direction.E) return new Point(p.x + 1, p.y);
        if (d == Creature.Direction.S) return new Point(p.x, p.y + 1);
        if (d == Creature.Direction.W) return new Point(p.x - 1, p.y);
        else return p;
    }

    //Returns type of neighboring ahead.
    private Creature.Neighboring typeAhead(Creature c) {
        try {
            return type(c, gird[movePointToAhead(c).x][movePointToAhead(c).y]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return Creature.Neighboring.WALL;
        }
    }

    //Returns type of second argument in relation to the first.
    private Creature.Neighboring type(Object obj1, Object obj2) {
        if (obj2 == null) {
            return Creature.Neighboring.EMPTY;
        } else {
            if (obj1.getClass().equals(obj2.getClass())) {
                return Creature.Neighboring.SAME;
            } else { if(isFood((Creature) obj1, (Creature) obj2)){
                return Creature.Neighboring.FOOD;
            }else {
                return Creature.Neighboring.OTHER;
            }
            }
        }
    }

    //Returns right rotated direction.
    private Creature.Direction rightRotate(Creature.Direction d) {

        if (d == Creature.Direction.N) return Creature.Direction.E;
        else if (d == Creature.Direction.E) return Creature.Direction.S;
        else if (d == Creature.Direction.S) return Creature.Direction.W;
        else if (d == Creature.Direction.W) return Creature.Direction.N;
        else return d;
    }


    public static void printGird(Creature[][] c)  {
        for (int i = 0; i < c.length; i++) {
            System.out.println();
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j]);
            }
        }

        System.out.println("\n");
    }

    public int countOfUnits() {
        int number = 0;
        for (int i = 0; i < this.gird.length; i++) {
            for (int j = 0; j < this.gird[0].length; j++) {
                if (this.gird[i][j] != null) number++;
            }
        }
        return number;
    }

    //Returns this.gird.
    public Creature[][] getGird() {
        return gird;
    }

    //Create new units.
    private Creature makeUnit(Class critter) {
        try {
            Constructor c = critter.getConstructors()[0];
            return (Creature) c.newInstance();
        } catch (Exception e) {
            System.out.println("ERROR Exception.");
            return null;
        }

    }

    //Returns direction symbol
    public static String getStringOfDirection(Creature.Direction d) {
        if (d == Creature.Direction.N) return "^";
        else if (d == Creature.Direction.E) return ">";
        else if (d == Creature.Direction.S) return "v";
        else return "<";

    }

    public HashMap<Creature, PrivateData> getInfo() {
        return info;
    }

    private boolean isFood(Creature obj1, Creature obj2){
        if(obj1.getPlaceInFoodChain().getCode() > obj2.getPlaceInFoodChain().getCode()){
            return true;
        } else {
            return false;
        }
    }


}
