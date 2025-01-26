package com.myschoolexercises.giocoinjava;


import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author lucav
 */

//The machines that refine the ingredients.
//If you drop an item inside it refines it and it will store the
//refined items until you collect them by clicking on it.
public class Machine extends Entity{
    private IngredientList inInv, outInv; //input and output inventory
    
    public Machine(ImageIcon image, Rectangle bounds, String name){
        super(image, bounds, name);
        inInv = new IngredientList();
        outInv = new IngredientList();
    }
    
    //Outputs the first ingredient of the outInv and removes it
    public Ingredient drop(){
        Ingredient temp = outInv.getIngredient(0);
        outInv.removeIngredient(outInv.getIngredient(0));
        return temp;
    }
    
    //Returns true or false if the outInv is empty or not
    public boolean isEmpty(){
        boolean empty = false;
        if(outInv.getIngredients().isEmpty()){
            empty = true;
        }
        return empty;
    }
}
