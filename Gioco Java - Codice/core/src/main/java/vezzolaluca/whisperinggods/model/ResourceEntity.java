/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vezzolaluca.whisperinggods.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;

/**
 *
 * @author lucav
 */
public class ResourceEntity extends PhisicalEntity{
    
    public ResourceEntity(){
        super();
    }
    
    public ResourceEntity(Sprite sprite, BodyDef bodyDef, FixtureDef fixtureDef) {
        super(sprite, bodyDef, fixtureDef);
    }
    
    public ResourceEntity(PhisicalEntity pE) {
        super(pE);
    }
}
