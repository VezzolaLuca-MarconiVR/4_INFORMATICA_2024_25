package vezzolaluca.whisperinggods;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class PlayerModel {
    private Sprite sprite;

    public PlayerModel(Texture texture, float x, float y, float width, float height) {
        sprite = new Sprite(texture);
        sprite.setBounds(x, y, width, height);
    }

    public void setPosition(float x, float y) {
        sprite.setX(x);
        sprite.setY(y);
    }
    public float[] getPosition(){
        float[] position = {sprite.getX(), sprite.getY()};
        return position;
    }
    
    
    public void setSize(float width, float height){
        sprite.setSize(width, height);
    }
    
    public void setX(float x){
        sprite.setX(x);
    }
    public float getX(){
        return sprite.getX();
    }
    
    public void setY(float y){
        sprite.setY(y);
    }
    public float getY(){
        return sprite.getY();
    }

    public void moveX(float deltaX) {
        sprite.setX(sprite.getX() + deltaX);
    }
    public void moveY(float deltaY) {
        sprite.setY(sprite.getY() + deltaY);
    }
    
    
    public float getWidth(){
        return sprite.getWidth();
    }
    public float getHeight(){
        return sprite.getHeight();
    }
    
    
    public void setTexture(Texture texture){
        sprite.setTexture(texture);
    }
    public Texture getTexture() {
        return sprite.getTexture();
    }
    
    
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }    
    public Sprite getSprite(){
        return sprite;
    }
}
