package com.myschoolexercises.aprebottegailprestaorecchio;

import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author lucav
 */
public class IngredientMenu extends JPanel{
    protected Image backImage; //The background of the IngredientMenu.
    protected double width, height; //The dimensions of the IngredientMenu panel.

    public IngredientMenu(Image backImage, double width, double height) {
        this.backImage = backImage;
        this.width = width;
        this.height = height;
    }
    
    //All the getters and setters
}
