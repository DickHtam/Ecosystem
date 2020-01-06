package com.company;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EcosystemFrame extends JFrame {


    private int frameWidth = 1000, frameHeight = 750;

    private static  boolean created;
    private boolean started = false;

    DisplayComponent dispComp;

    public EcosystemFrame(EcosystemModel model){
        //Check if one frame was created.
        if (created)
            throw new RuntimeException("Only one frame allow");
        created = true;
        //Frame title name.
        setTitle("Ecosystem 0.02");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Frame(window) location.
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds(dimension.width / 2 - (frameWidth / 2), dimension.height / 2 - (frameHeight / 2), frameWidth, frameHeight);

        dispComp = new DisplayComponent(model);
        add(dispComp);
        panel();
    }

    public void panel(){
        JPanel p = new JPanel();


        JLabel label = new JLabel("Quantity: " + dispComp.getModel().countOfUnits());

        JButton buttonStep = new JButton("step");
        buttonStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                label.setText("Quantity: " + dispComp.getModel().countOfUnits() + " Exceptions: " + EcosystemModel.exception);
                dispComp.getModel().step();
                // method who paint new state of component
                dispComp.repaint();

            }
        });
        p.add(label);
        p.add(buttonStep);


        JButton buttonCheckQuantity = new JButton("push");
        buttonCheckQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < dispComp.getModel().gird.length; i++) {
                    System.out.println();
                    for (int j = 0; j < dispComp.getModel().gird.length; j++) {
                        System.out.print(dispComp.getModel().getGird()[j][i] + " | ");

                    }

                }
                // method who paint new state of component
                dispComp.repaint();
            }
        });
        p.add(buttonCheckQuantity);
        add(p, BorderLayout.EAST);
    }

    public void start(){
        if (started){
            return;
        } else {
            this.setVisible(true);
        }

    }
}
