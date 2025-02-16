/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vezzolaluca.whisperinggods.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import java.util.ArrayList;
import java.util.Random;
import vezzolaluca.whisperinggods.controller.AssetLoader;

/**
 *
 * @author lucav
 */
public class SpawnerEntity extends Entity{
    protected static final int MAX_RESOURCES_SPWANED = 3;
    protected int spawningTime, remainingST, resourcesSpawned;
    protected ArrayList<ResourceEntity> possibleSpawns;
    
    public SpawnerEntity(Sprite sprite, int spawningTime, String name){
        this.sprite = sprite;
        this.spawningTime = spawningTime;
        this.name = name;
        remainingST = spawningTime;
        category = "spawner";
        resourcesSpawned = 0;
    }
    
    public void setPossibleSpawns(ArrayList<ResourceEntity> possibleSpawns){
        this.possibleSpawns = possibleSpawns;
    }
    
    public ResourceEntity spawnResource(){
        ResourceEntity resource;
        
        resourcesSpawned++;
        
        switch(this.name){
            case("pumpkin bush"):
                //new Random().nextInt(max - min + 1) + min
                resource = new Pumpkin(new Random().nextInt(3 - 1 + 1) + 1, this.sprite.getBoundingRectangle());
                break;
            default:
                //JUST FOR DEBUGGING - to always initialize resource
                //new Random().nextInt(max - min + 1) + min
                resource = new Pumpkin(new Random().nextInt(3 - 1 + 1) + 1, this.sprite.getBoundingRectangle());
                break;
        }
        
        return resource;
    }
    
    public void decreaseRemainingSpawningTime(){
        if(remainingST > 0){
            remainingST--;
        }else {
            remainingST = spawningTime;
        }
    }
    public float getRemainingST(){
        return remainingST;
    }
    
    public boolean canSpawnResource(){
        return remainingST == 0 && resourcesSpawned < MAX_RESOURCES_SPWANED;
    }
    
    //ALL OF THE POSSIBLE RESOURCES
    private class Pumpkin extends ResourceEntity{
        
        public Pumpkin(int type, Rectangle spawnerBounds){
            super();
            
            bodyDef = new BodyDef();
            fixtureDef = new FixtureDef();
            CircleShape circle1 = new CircleShape();
            CircleShape circle2 = new CircleShape();
            
            //Calculating random positions to spawn the entity casually inside the spawner bounds
            float randX = spawnerBounds.getX() + new Random().nextInt((int)(spawnerBounds.getWidth()*10) / 10);
            
            
            switch(type){
                case 1:
                    sprite = new Sprite(AssetLoader.manager.get(AssetLoader.PUMPKIN_1_TEXTURE, Texture.class));
                    sprite.setPosition(randX, 0);
                    sprite.setSize(1, 1);
                    
                    bodyDef.position.set(randX, 0);
                    
                    circle1.setRadius(0.5f);
                    fixtureDef.shape = circle1;
                    fixtureDef.density = 1f;
                    fixtureDef.friction = 3f;
                    fixtureDef.restitution = 0f;
                    break;
                case 2:
                    sprite = new Sprite(AssetLoader.manager.get(AssetLoader.PUMPKIN_2_TEXTURE, Texture.class));
                    sprite.setPosition(randX, 0);
                    sprite.setSize(2, (float) 2*sprite.getTexture().getHeight()/sprite.getTexture().getWidth());
                    
                    bodyDef.position.set(randX, 0);
                    
                    circle1.setRadius(0.7f);
                    circle2.setRadius(1f);
                    fixtureDef.shape = circle1;
                    fixtureDef.density = 1f;
                    fixtureDef.friction = 3f;
                    fixtureDef.restitution = 0f;
                    fixtureDef.shape = circle2;
                    fixtureDef.density = 1f;
                    fixtureDef.friction = 3f;
                    fixtureDef.restitution = 0f;
                    break;
                case 3:
                    sprite = new Sprite(AssetLoader.manager.get(AssetLoader.PUMPKIN_3_TEXTURE, Texture.class));
                    sprite.setPosition(randX, 0);
                    sprite.setSize(2, (float) 2*sprite.getTexture().getHeight()/sprite.getTexture().getWidth());
                    
                    bodyDef.position.set(randX, 0);
                    
                    circle1.setRadius((float) 2*sprite.getTexture().getHeight()/sprite.getTexture().getWidth()/2);
                    circle2.setRadius((float) 2*sprite.getTexture().getHeight()/sprite.getTexture().getWidth()/2);
                    fixtureDef.shape = circle1;
                    fixtureDef.density = 1f;
                    fixtureDef.friction = 3f;
                    fixtureDef.restitution = 0f;
                    fixtureDef.shape = circle2;
                    fixtureDef.density = 1f;
                    fixtureDef.friction = 3f;
                    fixtureDef.restitution = 0f;
                    break;
                default:

                    break;
            }
        }
    }
}
