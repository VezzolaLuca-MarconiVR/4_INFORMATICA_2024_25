/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.github.vezzolaluca.whisperinggods.components;

import com.badlogic.ashley.core.Component;

/**
 *
 * @author lucav
 */
public class MovementComponent implements Component {
    public float velocityX, velocityY; //Velocity in x and y direction of the entity
    
    public MovementComponent(float velocityX, float velocityY){
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }
}
