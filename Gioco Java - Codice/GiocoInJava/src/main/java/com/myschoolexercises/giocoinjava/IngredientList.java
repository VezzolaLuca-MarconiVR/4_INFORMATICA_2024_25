package com.myschoolexercises.giocoinjava;

import java.util.ArrayList;

/**
 *
 * @author lucav
 */
public class IngredientList {
    private ArrayList<Ingredient> ingredients;
    
    public IngredientList(){
        ingredients = new ArrayList<>();
    }
    
    //Adding and removing ingredients
    public void addIngredient(Ingredient i){
        ingredients.add(i);
    }
    
    public void removeIngredient(Ingredient ingredient){
        ingredients.remove(ingredient);
    }
    
    //Gets the ingredients list
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }
    
    //Gets the ingredient in the specified index
    public Ingredient getIngredient(int i){
        return ingredients.get(i);
    }
    
    //returns the list of the names and positions of the ingredients
    @Override
    public String toString(){
        String s = "";
        for(int i=0; i<ingredients.size(); i++){
            s += "Name: " + ingredients.get(i).getName() + "; ";
            s += "X: " + ingredients.get(i).getBounds().getX() + "; Y: " + ingredients.get(i).getBounds().getY() + ";";
            s += "Width: " + ingredients.get(i).getBounds().getWidth() + "; ";
            s += "Height: " + ingredients.get(i).getBounds().getHeight() + ";\n";
        }
        return s;
    }
    
    //Sorting an arraylist by the names of its elements
    public void sortByName(){
        for(int i=0; i<ingredients.size()-1; i++){
            for(int j=0; j<ingredients.size()-1; j++){
                //If the name of the ingredient in j comes after (alphabetically) the one in j+1, swap the two
                if(ingredients.get(j).getName().compareTo(ingredients.get(j+1).getName())>0){
                    swap(j, j+1);
                }
            }
        }
    }
    
    //Swaps two elements of the ArrayList
    public void swap(int i, int j){
        Ingredient tempI = ingredients.get(i).clone();
        ingredients.set(i, ingredients.get(j).clone());
        ingredients.set(j, tempI);
    }
}
