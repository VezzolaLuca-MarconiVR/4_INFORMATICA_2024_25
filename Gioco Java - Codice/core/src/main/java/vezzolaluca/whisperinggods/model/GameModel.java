package vezzolaluca.whisperinggods.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import vezzolaluca.whisperinggods.controller.AssetLoader;
import static vezzolaluca.whisperinggods.model.Constants.*;

public class GameModel {    
    /*
     * It is more efficient to send all your draw calls at once to the graphics processing unit (GPU).
     * The process of drawing an individual texture is called a draw call.
     * The SpriteBatch is how libGDX combines these draw calls together.
     */
    private SpriteBatch spriteBatch;
    
    //Viewports & Cameras: https://libgdx.com/wiki/graphics/viewports
    //private FillViewport viewport;
    private OrthographicCamera playerCamera;
    
    //Managing the phisics of the game
    private Vector2 gravity; //Settting the gravity to 10 towards the ground
    
    private World world; //The phisics simulation world
    
    private PlayerModel player;

    public EntityList worldEntityList;
    
    //SOLO PER IL DEBUG
    private Box2DDebugRenderer debugRenderer;
    
    public GameModel() {
        //Loading all of the assets into the AssetLoader
        AssetLoader.load();
        
        //initizlizing the graphic classes of the game
        spriteBatch = new SpriteBatch();
        playerCamera = new OrthographicCamera();
        playerCamera.setToOrtho(false, VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        //viewport = new FillViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT, playerCamera);
        
        //Physics initialization
        gravity = new Vector2(0, -10);
        /* The second value in the world creation is a boolean value which tells the world if we want objects to sleep or not.
        *  Generally we want objects to sleep as this conserves CPU usage,
        *  but there are situations where you might not want your objects to sleep. */
        world = new World(gravity, true);
        
        //Environment initialization
        //environment.addToWorld();
        
        //PLAYER INITIALIZATION
        Texture playerTexture = AssetLoader.manager.get(AssetLoader.BUCKET_TEXTURE, Texture.class);
        //Initialize the player's texture and position (the player's sprite)
        player = new PlayerModel(playerTexture, 5f, 4f, 1f, 1f);
        player.addToWorld(world);
        
        
        // GROUND INITIALIZATION
        BodyDef groundBodyDef = new BodyDef();  
        // Set its world position
        //groundBodyDef.position.set(viewport.getWorldWidth(), 0);  // Posizionarlo al centro orizzontale e altezza 0.1f
        groundBodyDef.position.set(playerCamera.viewportWidth / 2, 0);

        // Create a body from the definition and add it to the world
        Body groundBody = world.createBody(groundBodyDef);  

        PolygonShape groundBox = new PolygonShape();  
        // Set the polygon shape as a box which is twice the size of our view port and 20 high
        // (setAsBox takes half-width and half-height as arguments)
        //groundBox.setAsBox(viewport.getWorldWidth(), 0f);
        groundBox.setAsBox(playerCamera.viewportWidth / 2, 0f);
        // Create a fixture from our polygon shape and add it to our ground body  
        groundBody.createFixture(groundBox, 0.0f);
        groundBox.dispose();
        

        // LEFT WALL INITIALIZATION
        groundBodyDef.position.set(0, 0);
        PolygonShape leftWallBox = new PolygonShape();
        leftWallBox.setAsBox(0f, playerCamera.viewportHeight);
        
        Body leftWallBody = world.createBody(groundBodyDef);
        leftWallBody.createFixture(leftWallBox, 0.0f);
        leftWallBox.dispose();
        
        
        //RIGHT WALL INITIALIZATION
        groundBodyDef.position.set(playerCamera.viewportWidth, 0);
        PolygonShape rightWallBox = new PolygonShape();
        rightWallBox.setAsBox(0f, playerCamera.viewportHeight);
        
        Body rightWallBody = world.createBody(groundBodyDef);
        rightWallBody.createFixture(rightWallBox, 0.0f);
        rightWallBox.dispose();
        
        //Initializing all of the entities (phisical or not)
        worldEntityList = new EntityList();
        worldEntityList.addToWorld(world);
        
        //SOLO PER IL DEBUG
        debugRenderer = new Box2DDebugRenderer();
    }

    public PlayerModel getPlayer() {
        return player;
    }

    public Body getPlayerBody() {
        return player.getBody();
    }

    public OrthographicCamera getPCamera() {
        return playerCamera;
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
