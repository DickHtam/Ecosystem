package com.company;

import javax.swing.*;
import java.awt.*;

public class EcosystemFrame extends JFrame {
        private EcosystemModel myModel;
        private EcosystemPanel myPanel;
        private static boolean created;

        private int frameWidth = 1000;
        private int frameHeight = 700;


        //initially it has not started
        private boolean started = false;

        public EcosystemFrame(){
                // this prevents someone from trying to create their own copy of
                // the GUI components
                if (created)
                        throw new RuntimeException("Only one world allowed");
                created = true;
                setTitle("Ecosystem");
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                //Frame(window) location.
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                Dimension dimension = toolkit.getScreenSize();
                setBounds(dimension.width / 2 - (frameWidth / 2), dimension.height / 2 - (frameHeight / 2), frameWidth, frameHeight);
                //Frame title name.



        }


        public void start(){
                if(started){
                        return;
                } else {
                        this.setVisible(true);
                }


        }

}
