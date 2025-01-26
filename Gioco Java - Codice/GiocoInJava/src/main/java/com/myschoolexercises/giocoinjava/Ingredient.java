package com.myschoolexercises.giocoinjava;

import java.awt.Rectangle;
import javax.swing.ImageIcon;



/**
 *
 * @author lucav
 */

//The ingredients that can be grabbed from the inventory and dragged around the screen - e.g. to be fed to machines
public class Ingredient extends Entity{
    
    public Ingredient(ImageIcon image, Rectangle bounds, String name){
        super(image, bounds, name);
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
