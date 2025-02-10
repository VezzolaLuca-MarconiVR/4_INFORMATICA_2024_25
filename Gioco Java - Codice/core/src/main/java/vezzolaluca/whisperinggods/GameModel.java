package vezzolaluca.whisperinggods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameModel {
    private PlayerModel player;
    private SpriteBatch spriteBatch;
    private FitViewport viewport;
    
    //Managing the phisics of the game
    private Vector2 gravity; //Settting the gravity to 10 towards the ground
    /*
     * The second value in the world creation is a boolean value which tells the world if we want objects to sleep or not.
     * Generally we want objects to sleep as this conserves CPU usage,
     * but there are situations where you might not want your objects to sleep.
     */
    private World world; //The phisics simulation world
    private float accumulator;

    //SOLO PER IL DEBUG
    private Box2DDebugRenderer debugRenderer;

    
    public GameModel() {
        AssetLoader.load();
        Texture playerTexture = AssetLoader.manager.get(AssetLoader.BUCKET_TEXTURE, Texture.class);
        
        //Initialize the player's texture and position (sprite)
        player = new PlayerModel(playerTexture, 5f, 4f, 1f, 1f);
        
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(16, 9);
        
        //Physics initialization
        gravity = new Vector2(0, -10);
        world = new World(gravity, true);
        
        player.addToWorld(world);
        
        // Create our body definition
        BodyDef groundBodyDef = new BodyDef();  
        // Set its world position
        groundBodyDef.position.set(new Vector2(0, 0));

        // Create a body from the definition and add it to the world
        Body groundBody = world.createBody(groundBodyDef);  

        // Create a polygon shape
        PolygonShape groundBox = new PolygonShape();  
        // Set the polygon shape as a box which is twice the size of our view port and 20 high
        // (setAsBox takes half-width and half-height as arguments)
        groundBox.setAsBox(viewport.getWorldWidth(), 0.1f);
        // Create a fixture from our polygon shape and add it to our ground body  
        groundBody.createFixture(groundBox, 0.0f);
        
        //Recycling old variables
        groundBodyDef.position.set(new Vector2(0, 0));
        groundBox.setAsBox(0.1f, viewport.getWorldHeight());
        
        Body leftWallBody = world.createBody(groundBodyDef);
        leftWallBody.createFixture(groundBox, 0.0f);
        
        
        groundBodyDef.position.set(new Vector2(viewport.getWorldWidth(), 0));
        groundBox.setAsBox(0.1f, viewport.getWorldHeight());
        
        Body rightWallBody = world.createBody(groundBodyDef);
        rightWallBody.createFixture(groundBox, 0.0f);
        
        // Clean up after ourselves
        groundBox.dispose();
        
        //TESTING
        for(int i=0; i<1004; i++){
            // Create our body definition
            BodyDef casualDef = new BodyDef(); 
            casualDef.type = BodyDef.BodyType.DynamicBody;
            // Set its world position
            casualDef.position.set(new Vector2(i%(viewport.getWorldWidth()-2) + 1, i+10));
                // Create a body from the definition and add it to the world
            Body casualBody = world.createBody(casualDef);
            // Create a polygon shape
            CircleShape casualCircle = new CircleShape();  
            // Set the polygon shape as a box which is twice the size of our view port and 20 high
            // (setAsBox takes half-width and half-height as arguments)
            casualCircle.setRadius(i/10 % 0.3f);
            // Create a fixture from our polygon shape and add it to our ground body  
            casualBody.createFixture(casualCircle, 0.001f);
            // Clean up after ourselves
            casualCircle.dispose();
        }
        
        //SOLO PER IL DEBUG
        debugRenderer = new Box2DDebugRenderer();
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public Body getPlayerBody() {
        return player.getBody();
    }
    
    //returns the used viewport (Viewport is the parent class of all viewports)
    public Viewport getViewport(){
        return this.viewport;
    }
    
    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }

    public float getDeltaTime(){
        return Gdx.graphics.getDeltaTime();
    }
    
    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
    
    public void dispose(){
        AssetLoader.dispose();
        spriteBatch.dispose();
    }

    public Box2DDebugRenderer getDebugRenderer() {
        return debugRenderer;
    }
}
