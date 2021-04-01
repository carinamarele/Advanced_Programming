package org.example;



import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

/**
 * Clasa care imi ordoneaza si imi spune unde si cum va arata un lucru
 */
public class MainFrame extends JFrame {
    ConfigPanel configPanel; // stabilirea numerelor
    ControlPanel controlPanel; // butoanele save,reset,exit,load
    DrawingPanel canvas; // imaginea desenata
    JFrame frame;
    JLabel label;


    public MainFrame() {
        frame = new JFrame("Laborator 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        frame.pack();
        init();
    }
    //Imi aranjez obiectele, sus vor fi setarile pentru numarul de laturi si culoare
    //jos vor fi butoanele
    // in centru va fi afisata imaginea
    private void init() {

        configPanel = new ConfigPanel(this);
        frame.add(configPanel, BorderLayout.NORTH);

        canvas = new DrawingPanel(this);
        frame.add(canvas, BorderLayout.CENTER);

        controlPanel = new ControlPanel(this);
        frame.add(controlPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
    }
}