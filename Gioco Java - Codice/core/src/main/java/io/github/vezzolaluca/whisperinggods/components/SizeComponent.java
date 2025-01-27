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
public class SizeComponent implements Component{
    public float width, height; //The width and height of the entity
    
    public SizeComponent(float width, float height){
        this.width = width;
        this.height = height;
    }
}
