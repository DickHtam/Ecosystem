package com.company;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.text.AttributedCharacterIterator;
import java.util.Map;

public class DisplayEcosystemField extends JComponent {

            private EcosystemModel myModel;
            private static boolean created;
            private Font myFont;

            //Coordinates from which display starts.
            private int startingCoordinates[] = {40, 40};
            //Step between displayed components.
            private int step = 30;
            public static final int FONT_SIZE = 30;

            public DisplayEcosystemField(EcosystemModel model) {
                // this prevents someone from trying to create their own copy of
                // the GUI components
                if (created)
                    throw new RuntimeException("Only one world allowed");
                created = true;

                myModel = model;
                // construct font and compute char width once in constructor
                // for efficiency
//                myFont = new Font("Monospaced", Font.BOLD, FONT_SIZE + 4);
//                setBackground(Color.GREEN);
//                setPreferredSize(new Dimension(FONT_SIZE * model.getWidth() + 20,
//                        FONT_SIZE * model.getHeight() + 20));

            }
            //Method for display units' shapes. Also set font and and color for each shape.
            public void paintComponent(Graphics g){
                Graphics2D g2 = (Graphics2D)g;
                Font font = new Font("Monospaced", Font.BOLD, FONT_SIZE );
                setFont(font);
                for (int i = 0; i < myModel.getGird().length; i++) {
                    //Set line thickness.
                    g2.setStroke( new BasicStroke(2));
                    //Set line color.
                    g2.setColor(Color.GRAY);
                    //Draw line like gird.
                    g2.drawLine(startingCoordinates[0] - 5 , startingCoordinates[1] - 20 + (step * i),
                            485, startingCoordinates[0] - 20 + (step * i));
                    g2.drawLine( startingCoordinates[1] - 5 + (step * i), startingCoordinates[0] - 20,
                            startingCoordinates[0] - 5 + (step * i),
                            470);
                    for (int j = 0; j < myModel.getGird()[0].length; j++) {
                        if(myModel.getGird()[i][j] instanceof EcosystemUnit) {
                            //Set color for each unit.
                            g2.setColor(myModel.getGird()[i][j].getColor());
                            g2.drawString(myModel.getGird()[i][j].getShape(), startingCoordinates[0] + (step * i),
                                    startingCoordinates[1] + (30 * j));
                        } else {
                            g2.setColor(Color.GRAY);
                            g2.drawString(" ", 40 + (30 * i), 40 + (30 * j));

                        }
                    }

                }
            }


}
