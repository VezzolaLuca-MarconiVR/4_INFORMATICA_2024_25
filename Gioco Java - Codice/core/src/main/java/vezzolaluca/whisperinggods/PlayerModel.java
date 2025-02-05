package vezzolaluca.whisperinggods;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class PlayerModel {
    private Sprite sprite;
    private float x;
    private float y;
    private float width;
    private float height;
    private float speed; //(in the x direction)
    private float acceleration;
    
    //phisics2D
    private BodyDef bodyDef; //Body-definition
    private FixtureDef fixtureDef; //Fixture-definition
    private PolygonShape rectangle;

    public PlayerModel(Texture texture, float x, float y, float width, float height) {
        //Input parameters
        sprite = new Sprite(texture);
        sprite.setBounds(x, y, width, height);
        
        //Body-definition initialization
        speed = 0.2f;
        //The body descryption
        bodyDef = new BodyDef();
        bodyDef.type = BodyType.DynamicBody; //A dynamic body moves when a force is applied
        bodyDef.position.set(x, y); //Sets the position fo the simulation corresponding to the position of the center of the sprite
        
        //Body fixture-definition and fixture initialization
        rectangle = new PolygonShape();
        rectangle.setAsBox(width, height);
        
        fixtureDef = new FixtureDef();
        
        fixtureDef.shape = rectangle;
        fixtureDef.density = 0.6f;
        fixtureDef.friction = 0.4f;
        fixtureDef.restitution = 0.4f;
        
        //circle.dispose(); //Disposing the shape since it won't be used anymore
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

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
    
    //Physics getters and setters
    public BodyDef getBodyDef() {
        return bodyDef;
    }

    public void setBodyDef(BodyDef bodyDef) {
        this.bodyDef = bodyDef;
    }

    public FixtureDef getFixtureDef() {
        return fixtureDef;
    }

    public void setFixtureDef(FixtureDef fixtureDef) {
        this.fixtureDef = fixtureDef;
    }
}
