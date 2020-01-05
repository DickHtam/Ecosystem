package com.company;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EcosystemModel {

    //Name of neighboring on the gird.
    public enum Neighboring {
        SAME, OTHER, WALL, FOOD, EMPTY
    }

    //Direction, this is which direction object will do next step.
    public enum Direction {
        N, S, W, E
    }
    //Size of gird.
    public final static int WIDTH = 20, HEIGHT = 20;

    private int totalNumberOfCreature = 0;

    private HashMap<Creature, PrivateData> info;

    Creature[][] gird;

    public EcosystemModel() {
        this.gird = new Creature[WIDTH][HEIGHT];
        info = new HashMap<>();
    }

    //Data about object in the model. (Like direction, coordinates, etc.)
    public class PrivateData {
        public Point point;
        public Direction direction;

        public PrivateData(Point p, Direction d) {
            this.point = p;
            this.direction = d;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public Point getPoint() {
            return this.point;
        }
    }

    //Add units int model and fill the gird.
    public void addUnits(int numberOfCreature, Class unit) {
        int randomW, randomH;
        Direction[] directions = Direction.values();
        for (int i = 0; i < numberOfCreature; i++) {
            do {
                randomW = getRandomValueInRange(0, WIDTH);
                randomH = getRandomValueInRange(0, HEIGHT);
//                        randomW = 7;
//                        randomH = 6;
            } while (this.gird[getRandomValueInRange(0, WIDTH)][getRandomValueInRange(0, HEIGHT)] != null);
            if(this.gird[randomW][randomH] == null) this.gird[randomW][randomH] = makeUnit(unit); else i--;

            Direction d = Direction.N;
            //Fill HashMap info.
            info.put(this.gird[randomW][randomH], new PrivateData(new Point(randomW, randomH), d));

        }
        this.totalNumberOfCreature = this.totalNumberOfCreature + numberOfCreature;
    }

    //Method which executes of moving for each object in the gird.
    public void step() {
        Object[] list = info.keySet().toArray();
        Point p;
        Point pH;

        for (int i = 0; i < list.length; i++) {
            if (type((Creature) list[i]) == Neighboring.EMPTY) {
                            p = info.get((Creature) list[i]).point;
                            pH = movePointToAhead((Creature) list[i]);
                            info.get((Creature) list[i]).point = pH;
                            gird[pH.x][pH.y] = gird[p.x][p.y];
                            gird[p.x][p.y] = null;
                        } else {
                            info.get(list[i]).direction = rightRotate(info.get(list[i]).direction);
                        }

        }

//        int n = 100, k = 100;
//        for (int i = 0; i < gird.length; i++) {
//            for (int j = 0; j < gird[0].length; j++) {
//                if(n == i && k == j){
//                    n = 100;
//                    k = 100;
//                } else {
//                    if (gird[i][j] instanceof Creature) {
//                        if (type(gird[i][j]) == Neighboring.EMPTY) {
//                            info.get(gird[i][j]).point = movePointToAhead(gird[i][j]);
//                            gird[info.get(gird[i][j]).getPoint().x][info.get(gird[i][j]).getPoint().y] = gird[i][j];
//                            n = info.get(gird[i][j]).getPoint().x;
//                            k = info.get(gird[i][j]).getPoint().y;
//                            gird[i][j] = null;
//                        } else {
//                            info.get(gird[i][j]).direction = rightRotate(info.get(gird[i][j]).direction);
//                        }
//                    }
//                }
//            }
//        }
    }

    //Returns "Point" which contains coordinates "x" and "y", which are coordinates for the next proposed location.
    public Point movePointToAhead(Direction d, Point p) {
        if (d == Direction.N) return new Point(p.x, p.y - 1);
        if (d == Direction.E) return new Point(p.x + 1, p.y);
        if (d == Direction.S) return new Point(p.x, p.y + 1);
        if (d == Direction.W) return new Point(p.x - 1, p.y);
        else return p;
    }

    public Point movePointToAhead(Creature c) {
        Direction d = info.get(c).getDirection();
        Point p = info.get(c).getPoint();
        if (d == Direction.N) return new Point(p.x, p.y - 1);
        if (d == Direction.E) return new Point(p.x + 1, p.y);
        if (d == Direction.S) return new Point(p.x, p.y + 1);
        if (d == Direction.W) return new Point(p.x - 1, p.y);
        else return p;
    }

    //Returns type of neighboring ahead.
    private Neighboring type(Creature c) {
        try {
            return type(c, gird[movePointToAhead(c).x][movePointToAhead(c).y]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return Neighboring.WALL;
        }
    }

    //Returns type of second argument in relation to the first.
    private Neighboring type(Object obj1, Object obj2) {
        if (obj2 == null) {
            return Neighboring.EMPTY;
        } else {
            if (obj1.getClass().equals(obj2.getClass())) {
                return Neighboring.SAME;
            } else {
                return Neighboring.OTHER;
            }
        }
    }

    //Returns right rotated direction.
    private Direction rightRotate(Direction d) {

        if (d == Direction.N) return Direction.E;
        else if (d == Direction.E) return Direction.S;
        else if (d == Direction.S) return Direction.W;
        else if (d == Direction.W) return Direction.N;
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
        return this.gird;
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
    public static String getStringOfDirection(Direction d) {
        if (d == Direction.N) return "^";
        else if (d == Direction.E) return ">";
        else if (d == Direction.S) return "v";
        else return "<";

    }

    public HashMap<Creature, PrivateData> getInfo() {
        return this.info;
    }

    //Create random int in range.
    public static int getRandomValueInRange(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }
}
