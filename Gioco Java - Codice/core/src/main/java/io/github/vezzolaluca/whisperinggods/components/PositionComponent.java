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
public class PositionComponent implements Component {
    public float x, y; //The x and y of the entity
    
    public PositionComponent(float x, float y){
        this.x = x;
        this.y = y;
    }
}
