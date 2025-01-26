/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myschoolexercises.aprebottegailprestaorecchio;

import java.awt.*;

/**
 *
 * @author lucav
 */

//The ingredients that can be grabbed from the inventory and dragged around the screen - e.g. to be fed to machines
public class Ingredient extends Entity{
    private boolean isPressed;
    
    public Ingredient(Image image, Rectangle bounds, String name){
        super(image, bounds, name);
        isPressed = false;
    }
    
    //Clone method
    @Override
    public Ingredient clone(){
        return new Ingredient(this.image, this.bounds, this.name);
    }

    public void drag(int x, int y){
        bounds.setLocation(x, y);
    }
}
