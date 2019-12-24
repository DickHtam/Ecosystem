package com.company;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
//
//    static class MeComponent extends JComponent{
//        @Override
//        protected void paintComponent(Graphics g) {
//            Graphics2D g2 = (Graphics2D)g;
//            g2.drawString("Hi", 20, 20);
//        }
//    }


    public static void main(String[] args) throws Exception {
            EcosystemModel obj = new EcosystemModel(4, 4);
            obj.addUnit(3, Plant.class);
        for (int i = 0; i < obj.getGird().length; i++) {
            for (int j = 0; j < obj.getGird()[0].length; j++) {
                System.out.println(obj.getGird()[i][j]);

            }

        }

//            EcosystemModel obj = new EcosystemModel(5, 5);
//            obj.addUnits();
//
//            Font font = new Font("Bits")
//
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                try {
//                    System.out.println(obj.getGird()[i][j].getShape());
//                } catch (NullPointerException e){
//                    System.out.println("Ex");
//                }
//
//
//            }



    }
}
