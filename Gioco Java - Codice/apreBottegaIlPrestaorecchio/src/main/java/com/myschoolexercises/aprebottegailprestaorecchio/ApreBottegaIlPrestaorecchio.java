package com.myschoolexercises.aprebottegailprestaorecchio;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;


/**
 *
 * @author lucav
 */
public class ApreBottegaIlPrestaorecchio {
    
    public static void main(String[] args) {
        //Window size variables
        int frameWidth = 1000;
        int frameHeight = 600;

        //Creating the window
        JFrame window = new JFrame();
        window.setSize(frameWidth, frameHeight);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Game game = new Game();
        window.add(game);
        //game.pack();
        
        window.setVisible(true);
    }
}
