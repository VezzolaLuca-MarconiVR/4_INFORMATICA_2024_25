/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

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
        JFrame game = new JFrame();
        game.setSize(frameWidth, frameHeight);
        game.setLocationRelativeTo(null);
        game.setResizable(false);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Game core = new Game();
        game.add(core);
        //game.pack();
        
        game.setVisible(true);
    }
}
