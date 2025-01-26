package com.myschoolexercises.giocoinjava;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author lucav
 */
public class Game extends JPanel{
    //Dimensions of the game panel
    private int panelWidth = 1800;
    private int panelHeight = 1000;
    
    //Panels
    Room room;
    PlayerInventory pInventory;    
    
    public Game(){
        this.setSize(panelWidth, panelHeight);
        this.setBackground(Color.blue);
        
        //Initializing the room and the player inventory panels
        room = new Room();
        pInventory = new PlayerInventory();
        
        
        //Testing:
        //*****************************************************************************//
        ImageIcon appleImg = new ImageIcon(getClass().getResource("/assets/images/apple.png"));
        Rectangle appleBounds = new Rectangle(0, 0, 100, 100);
        pInventory.addIngredient(new Ingredient(appleImg, appleBounds, "Apple"));
        //*****************************************************************************//


        
        //Adding the panels to the window
        this.setLayout(new BorderLayout());
        this.add(room, BorderLayout.LINE_START);
        this.add(pInventory, BorderLayout.LINE_END);
        
        //Redrawing the window
        this.repaint();
    }
}
