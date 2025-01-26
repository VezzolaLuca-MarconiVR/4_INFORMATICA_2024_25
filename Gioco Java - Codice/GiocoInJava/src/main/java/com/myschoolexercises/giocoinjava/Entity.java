package com.myschoolexercises.giocoinjava;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author lucav
 */

//This is the parent class for all of the entities inside the game.
abstract class Entity {
    protected ImageIcon image; //The image of the entity.
    protected Rectangle bounds; //The bounds ("hitbox") of the entity (a rectangle) - it contains the width, height and x y coordinates.
    protected String name; //The name of the entity
    protected JLabel viewComponent;
    
    public Entity(ImageIcon image, Rectangle bounds, String name){
        this.image = image;
        this.bounds = bounds;
        this.name = name;
        viewComponent.setIcon(image);
        viewComponent.setBounds(bounds);
    }
    
    //All the setters and getters
    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    //Sets the location of the top-left corner of the entity
    public void setLocation(int x, int y){
        bounds.setLocation(x, y);
    }
    
    //Sets the location of the entity to have the specified point in the middle (used for mouse dragging)
    public void setLocation(Point p) {
        int x = (int) Math.round(p.getX() + bounds.getWidth() / 2);
        int y = (int) Math.round(p.getY() + bounds.getHeight() / 2);
        Point middlePoint = new Point(x, y);
        bounds.setLocation(middlePoint);
    }
    
    //Returns the JLabel for drawing this entity easily
    public JLabel getLabel(){
        return viewComponent;
    }
}
