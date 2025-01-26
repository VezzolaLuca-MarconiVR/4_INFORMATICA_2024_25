package com.myschoolexercises.giocoinjava;

import javax.swing.*;


/**
 *
 * @author lucav
 */
public class GiocoInJava {
    
    public static void main(String[] args) {
        //Window size variables
        int frameWidth = 1920;
        int frameHeight = 600;

        //Creating the window
        JFrame window = new JFrame();
        window.setSize(frameWidth, frameHeight);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Game game = new Game();
        window.add(game);
        window.pack();
        
        window.setVisible(true);
    }
}
