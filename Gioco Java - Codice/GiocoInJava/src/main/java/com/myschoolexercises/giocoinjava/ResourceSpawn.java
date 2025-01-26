package com.myschoolexercises.giocoinjava;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author lucav
 */

//The resources that, when clicked, give the player the corresponding ingredient
public class ResourceSpawn extends Entity {
    
    public ResourceSpawn(ImageIcon image, Rectangle bounds, String name){
        super(image, bounds, name);
    }    
}
