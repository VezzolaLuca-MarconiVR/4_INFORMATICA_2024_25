package com.myschoolexercises.aprebottegailprestaorecchio;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author lucav
 */
public class Game extends JPanel{
    //Dimensions of the game panel
    private int panelWidth = 1920;
    private int panelHeight = 1080;
    
    //Panels
    Room room;
    PlayerInventory pInventory;
    
    
    //Testing
    Image appleImg;
    
    
    public Game(){
        this.setSize(panelWidth, panelHeight);
        this.setBackground(Color.blue);
        
        //Using ImageIcon and getResource but then using a getImege is a more robust way for loading an image
        //backgroundImg = new ImageIcon(getClass().getResource("/images/img.png")).getImage();
        
        //Initializing the room and the player inventory panels
        room = new Room();
        pInventory = new PlayerInventory();
        
        
        //Testing
        appleImg = new ImageIcon(getClass().getResource("/images/apple.png")).getImage();
        Rectangle appleBounds = new Rectangle(0, 0, 100, 100);
        pInventory.addIngredient(new Ingredient(appleImg, appleBounds, "Apple"));
        
        //Adding the panels to the window
        this.setLayout(new BorderLayout());
        this.add(room, BorderLayout.LINE_START);
        this.add(pInventory, BorderLayout.LINE_END);
        
        //Redrawing the window
        this.repaint();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    
    public void draw(Graphics g){
        //background
        //g.drawImage(backgroundImg, 0, 0, panelWidth, panelHeight, null);
        room.draw(g);
        pInventory.draw(g);
    }
}
