/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vezzolaluca.whisperinggods.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 *
 * @author lucav
 */
public class PhisicalEntity extends Entity{
    protected Body body;
    protected BodyDef bodyDef;
    protected FixtureDef fixtureDef;
    
    public PhisicalEntity(){
        
    }
    
    public PhisicalEntity(Sprite sprite, BodyDef bodyDef, FixtureDef fixtureDef){
        super(sprite);
        this.bodyDef = bodyDef;
        this.fixtureDef = fixtureDef;
        body = null;
    }
    
    //Cloner
    public PhisicalEntity(PhisicalEntity pE){
        super(pE.sprite);
        this.bodyDef = pE.bodyDef;
        this.fixtureDef = pE.fixtureDef;
    }
    
    //Physics getters and setters
    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
    
    //Changing the type of the body
    public void setAsStatic(){
        body.setType(BodyDef.BodyType.StaticBody);
    }
    
    public void setAsDynamic(){
        body.setType(BodyDef.BodyType.DynamicBody);
    }
    
    public void setAsKinematic(){
        body.setType(BodyDef.BodyType.KinematicBody);
    }
    
    public void addToWorld(World world){
        this.setBody(world.createBody(bodyDef)); // Create the player body in the world using its body definition
        this.body.createFixture(fixtureDef); //Attach the player fixture to the player body
    }
    
    public void updatePositionAccordingToBody(){
        sprite.setPosition(body.getPosition().x, body.getPosition().y);
    }
}
