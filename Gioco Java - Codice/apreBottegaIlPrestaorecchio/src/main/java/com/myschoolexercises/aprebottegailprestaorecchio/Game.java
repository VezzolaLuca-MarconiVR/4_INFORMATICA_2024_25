/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myschoolexercises.aprebottegailprestaorecchio;

import javax.swing.*;
import java.awt.*;
import javax.swing.ImageIcon;

/**
 *
 * @author lucav
 */
public class Game extends JPanel{
    //Dimensions of the game panel
    private int panelWidth = 1000;
    private int panelHeight = 600;
    
    //Images
    Image backgroundImg;
    
    
    public Game(){
        this.setSize(panelWidth, panelHeight);
        setBackground(Color.blue);
        
        
        //Using ImageIcon and getResource but then using a getImege is a more robust way for loading an image
        backgroundImg = new ImageIcon(getClass().getResource("/images/QG_Nerv.png")).getImage();
        
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    
    public void draw(Graphics g){
        //background
        g.drawImage(backgroundImg, 0, 0, panelWidth, panelHeight, null);
    }
}
