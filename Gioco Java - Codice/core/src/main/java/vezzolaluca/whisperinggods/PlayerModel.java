package vezzolaluca.whisperinggods;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.CircleShape;

public class PlayerModel {
    private Sprite sprite;
    private Vector2 movementVector; //The force of the movement of the player [Newton/s]
    private Vector2 jumpVector; //The vector of the impulse allpied when jumping
    
    //phisics2D
    private BodyDef bodyDef; //Body-definition
    private FixtureDef fixtureDef; //Fixture-definition
    private Body body;

    public PlayerModel(Texture texture, float x, float y, float width, float height) {
        //Sprite initialization
        sprite = new Sprite(texture);
        sprite.setBounds(x, y, width, height);
        
        //Movement initialization
        movementVector = new Vector2(5f, 0f); //The movement vector (Always right. To make it go left put a "-" before the x)
        jumpVector = new Vector2(0f, 1f); //Use it for an upwards impulse
        
        //Body-definition initialization
        //The body descryption
        bodyDef = new BodyDef();
        bodyDef.type = BodyType.DynamicBody; //A dynamic body moves when a force is applied
        bodyDef.position.set(x, y); //Sets the position fo the simulation corresponding to the position of the center of the sprite
        
        //Body fixture-definition and fixture initialization
        CircleShape circle = new CircleShape();
        circle.setRadius(width/2);
        
        fixtureDef = new FixtureDef();
        
        fixtureDef.shape = circle;
        fixtureDef.density = 1f;
        fixtureDef.friction = 1f;
        fixtureDef.restitution = 0f;
    }
    
    
    //GETTERS AND SETTERS
    
    //Sprite
    public void setPosition(Vector2 pos) {
        sprite.setX(pos.x);
        sprite.setY(pos.y);
        
    }
    
    public void setPosition(float x, float y) {
        sprite.setX(x);
        sprite.setY(y);
        
    }
    
    public Vector2 getPosition(){
        Vector2 position = new Vector2(sprite.getX(), sprite.getY());
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
    
    //Movement
    public Vector2 getMovementVector() {
        return movementVector;
    }

    public void setMovementVector(Vector2 movementVector) {
        this.movementVector = movementVector;
    }

    public Vector2 getJumpVector() {
        return jumpVector;
    }

    public void setJumpVector(Vector2 jumpVector) {
        this.jumpVector = jumpVector;
    }
    
    
    //Physics
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

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
