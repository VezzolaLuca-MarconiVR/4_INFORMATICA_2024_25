/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vezzolaluca.whisperinggods.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import vezzolaluca.whisperinggods.controller.AssetLoader;

/**
 *
 * @author lucav
 */
public class Entity {
    protected Sprite sprite;
    protected String name;
    protected String category;
    
    public Entity(){
        sprite = new Sprite();
        sprite.setTexture(AssetLoader.manager.get(AssetLoader.BACKGROUND_TEXTURE, Texture.class));
        sprite.setBounds(0, 0, 1, 1);
        category = "";
    }
    
    public Entity(Sprite sprite){
        this.sprite = sprite;
    }
    
    public Entity(Texture texture, float x, float y, float width, float height){
        sprite.setTexture(texture);
        sprite.setBounds(x, y, width, height);
    }
    
    //Optional variables
    public void setName(String name){
        if(!name.isEmpty()){
            this.name = name;
        }else {
            this.name = "Invalid name";
        }
    }
    public String getName(){
        return name;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    public String getCategory(){
        return category;
    }
    
    public void draw(SpriteBatch spriteBatch){
        spriteBatch.draw(sprite.getTexture(), sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }
    
    @Override
    public String toString(){
        return name + "; " + category + "; " + sprite.getX() + "; " + sprite.getY();
    }
}
