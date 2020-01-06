package com.company;

import java.awt.*;
import javax.swing.*;



public class Main {

    public static void main(String[] args) {
	EcosystemModel ecosystemModel = new EcosystemModel();
	ecosystemModel.addUnits(10, Predator.class);
	ecosystemModel.addUnits(10, Herbivore.class);
	ecosystemModel.addUnits(10, Plant.class);
	EcosystemFrame frame = new EcosystemFrame(ecosystemModel);

	frame.start();

    }
}
