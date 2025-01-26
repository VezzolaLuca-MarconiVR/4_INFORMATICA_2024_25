package com.myschoolexercises.giocoinjava;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

/**
 *
 * @author lucav
 */
public class Room extends JPanel implements MouseInputListener{
    IngredientList ingredients;
    ArrayList<Machine> machines;
    Machine millstone; //for crushing
    //Machine oven; //for cooking
    //Machine drier; //for drying
    //Machine boiler; //for infusing
    
    public Room(){
        //Impostazioni iniziali
        this.setBackground(Color.GREEN);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        //Initialising the lists of the room
        ingredients = new IngredientList();
        machines = new ArrayList<>();
        
        //Initialising the machines
        ImageIcon millstoneImg = new ImageIcon(getClass().getResource("/assets/images/millstone.png"));
        millstone = new Machine(millstoneImg, new Rectangle(100, 100, 300, 300), "Millstone");
        
        
        //Adding the machines to the room
        machines.add(millstone);
        //machines.add(oven);
        //machines.add(drier);
        //machines.add(boiler);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(int i=0; i<machines.size(); i++){
            if(machines.get(i).bounds.contains(e.getPoint())){
                //If the machine's output inventory isn't empty, drop the item
                //and add it to the room ingredients list.
                if(!machines.get(i).isEmpty()){
                    ingredients.addIngredient(machines.get(i).drop());
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for(int i=0; i<ingredients.getIngredients().size(); i++){
            if(ingredients.getIngredient(i).getBounds().contains(e.getPoint())){
                    ingredients.getIngredient(i).setLocation(e.getPoint());
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Disegna gli ingredienti
        for (int i=0; i<ingredients.getIngredients().size(); i++) {
            this.add(ingredients.getIngredient(i).getLabel());
        }
        // Disegna le macchine
        for (Machine machine : machines) {
            this.add(machine.getLabel());
        }
    }
}
