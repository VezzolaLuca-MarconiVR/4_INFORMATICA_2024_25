package com.myschoolexercises.giocoinjava;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author lucav
 */
public class PlayerInventory extends JPanel {
    private double width, height; //The dimensions of the IngredientMenu panel.
    private IngredientList ingredients;
    
    public PlayerInventory(){
        this.setBackground(Color.RED);
        ingredients = new IngredientList();
        this.setPreferredSize(new Dimension(300, 600));
    }
    
    //All the getters and setters (getWidth and getHeight are already in the JPanel class)   
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    
    public void addIngredient(Ingredient ingredient){
        ingredients.addIngredient(ingredient);
    }
    
    //The drawing method

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Disegna gli ingredienti nell'inventario
        for (Ingredient ingredient : ingredients.getIngredients()) {
            
        }
    }
    
}