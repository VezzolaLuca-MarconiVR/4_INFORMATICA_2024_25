package com.myschoolexercises.aprebottegailprestaorecchio;

import java.awt.*;

/**
 *
 * @author lucav
 */

//This is the parent class for all of the entities inside the game.
abstract class Entity {
    protected Image image; //The image of the entity.
    protected double width, height; //The dimensions of the entity (a rectangle).
    protected double posX, posY; //The position of the entity.
    
    protected String name; //The name of the entity
    
    public Entity(){
        
    }

    
    //All the setter and getters for image, width, height, posX and posY.
    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
