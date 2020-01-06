package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayComponent extends JComponent {

    public final static int FONT_SIZE = 20;

        private static int beginningCoordinateI = 40, beginningCoordinateI1 = 40;
        private static boolean alreadyDisplayed;
        private EcosystemModel modelToDisplay;
        private int step = 30;

    public DisplayComponent(EcosystemModel myModel){
        if(alreadyDisplayed) throw new RuntimeException("Component is already displayed");
        Font font = new Font("Monospaced", Font.BOLD, FONT_SIZE );
        setFont(font);
        modelToDisplay = myModel;
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;

        g2.drawString("i", beginningCoordinateI - 15,
                beginningCoordinateI1 - 5);
        g2.drawString("j", beginningCoordinateI - 35,
                beginningCoordinateI1 + 5);
        for (int i = 0; i < modelToDisplay.getGird().length; i++) {
            //Set line thickness.
            g2.setStroke( new BasicStroke( 1.5f));
            //Set line color.
            g2.setColor(Color.GRAY);
            //Draw line like gird.
            g2.drawLine(beginningCoordinateI, beginningCoordinateI1 + (30 * i),
                    beginningCoordinateI + (30 * modelToDisplay.getGird().length), beginningCoordinateI1 + (30 * i));

            g2.drawLine(beginningCoordinateI1 + (30 * i), beginningCoordinateI,
                    beginningCoordinateI1 + (30 * i),beginningCoordinateI + (30 * modelToDisplay.getGird().length));

            //Numbers of columns and rows.
            g2.drawString("" + i, beginningCoordinateI - 35,
                    beginningCoordinateI1 + 25 + (i * 30) );
            g2.drawString("" + i, beginningCoordinateI + 5 + (i * 30),
                            beginningCoordinateI1 - 5);
            for (int j = 0; j < modelToDisplay.getGird()[0].length; j++) {
                if(modelToDisplay.getGird()[i][j] instanceof Creature) {
                    //Set color for each unit.
                    g2.setColor(modelToDisplay.getGird()[i][j].getColor());
                    try {
                        g2.drawString(EcosystemModel.getStringOfDirection(getModel().getInfo().
                                        get(getModel().getGird()[i][j]).getDirection()),
                                beginningCoordinateI + 7 + (i * 30),
                                beginningCoordinateI1 + 28 + (j * 30));
                    } catch (NullPointerException n){
                        System.out.println("Exception in DisplayComponent");
                    }
                }
            }
        }
        //Draw the last two lanes.
        g2.setColor(Color.GRAY);
        g2.drawLine(beginningCoordinateI, beginningCoordinateI1 + (30 * 20),
                beginningCoordinateI + (30 * modelToDisplay.getGird().length), beginningCoordinateI1 + (30 * 20));
        g2.drawLine(beginningCoordinateI + (30 * 20), beginningCoordinateI1,
                beginningCoordinateI + (30 * 20),beginningCoordinateI1 + (30 * modelToDisplay.getGird().length));
    }




    public EcosystemModel getModel(){
        return this.modelToDisplay;
    }
}
