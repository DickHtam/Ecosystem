package com.company;

import java.awt.*;
import javax.swing.*;



public class Main {

    public static void main(String[] args) {
	EcosystemModel ecosystemModel = new EcosystemModel();
	ecosystemModel.addUnits(50, Creature.class);
	EcosystemFrame frame = new EcosystemFrame(ecosystemModel);

	frame.start();

//		for (int i = 0; i < ecosystemModel.gird.length; i++) {
//			System.out.println();
//			for (int j = 0; j < ecosystemModel.gird.length; j++) {
//				System.out.print(ecosystemModel.getGird()[j][i] + " | ");
//
//			}
//
//		}
    }
}
