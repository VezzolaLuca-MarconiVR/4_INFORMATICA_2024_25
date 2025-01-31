package vezzolaluca.whisperinggods;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Core extends ApplicationAdapter {  
    //A texture is the information of an image loaded inside the RAM.
    Texture backgroundTexture;
    Texture bucketTexture;
    Texture dropTexture;
    
    /*
     * Sounds that are <10 seconds should be a Sound object, the rest is a Music
     * (by using a Music object the sound is streamed and not stored in RAM as a whole).
     */
    Sound dropSound;
    Music music;
    
    /*
     * It is more efficient to send all your draw calls at once to the graphics processing unit (GPU).
     * The process of drawing an individual texture is called a draw call.
     * The SpriteBatch is how libGDX combines these draw calls together.
     */
    SpriteBatch spriteBatch;
    
    //Viewports & Cameras: https://libgdx.com/wiki/graphics/viewports
    FitViewport viewport;
    
    /*
     * We need some way of keeping track of where the player bucket is in the game world.
     * Texture does not store any position state. Sure, you can tell SpriteBatch where to draw it every
     * frame by using the provided overloaded methods. What if you want to rotate it? Resize it?
     * These methods get incredibly complicated the more you want to do.
     * Let’s use a Sprite instead. Sprite is capable of doing all these things and keeping state. This means that
     * it will remember its properties instead of you having to define them every frame.
    */
    Sprite bucketSprite; // Declare a new Sprite variable
    
    //Vettore per l'input mouse/touch
    Vector2 touchPos;
    
    @Override
    public void create() {
        backgroundTexture = new Texture("background.png");
        bucketTexture = new Texture("bucket.png");
        dropTexture = new Texture("drop.png");
        
        bucketSprite = new Sprite(bucketTexture); // Initialize the sprite based on the texture
        bucketSprite.setSize(1, 1); // Define the size of the sprite

        dropSound = Gdx.audio.newSound(Gdx.files.internal("drop.mp3"));
        music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
        
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);
        
        
        touchPos = new Vector2();
    }

    @Override
    public void render() {
        // organize code into three methods
        input();
        logic();
        draw();
    }
    
    @Override
    public void resize (int width, int height) {
        viewport.update(width, height, true); // true centers the camera
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }
    
    @Override
    public void dispose() {
        
    }
    
    
    
    //render() methods:
    private void input() {
        float speed = 4f;
        float delta = Gdx.graphics.getDeltaTime();

        //Input da tastiera
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            bucketSprite.translateX(speed * delta); // move the bucket right
        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            bucketSprite.translateX(-speed * delta); // move the bucket left
        }
        
        //Input mouse o touch
        if (Gdx.input.isTouched()) {
        touchPos.set(Gdx.input.getX(), Gdx.input.getY()); // Get where the touch happened on screen
        viewport.unproject(touchPos); // Convert the units to the world units of the viewport
        bucketSprite.setCenterX(touchPos.x); // Change the horizontally centered position of the bucket
    }
    }

    private void logic(){

    }

    private void draw() {
        /*
         * It’s a good practice to clear the screen every frame.
         * Otherwise, you’ll get weird graphical errors. You can use any color you want.
         */
        ScreenUtils.clear(Color.BLACK);
        
        viewport.apply();
        
        //Shows how the Viewport is applied to the SpriteBatch. This is necessary for the images to be shown in the correct place.
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        
        // add lines to draw stuff in here, between begin and end
        spriteBatch.begin();
        /*
         * The coordinates we provide determine where the bucket will be drawn on the screen.
         * The coordinates begin in the bottom left and grow to the right and up.
         * Our game world is described in imaginary units best defined as meters.
         * 
         * For simplicity, 100 pixels will equal 1 meter.
         * This ratio of pixels per meter can be anything you want, but make sure whatever you choose is a simple value that
         * makes sense in your game world. This is typically the size of your tiles or the height of the player character.
         * 
         * Your game logic should really know nothing about pixels.
         */
        
        // store the worldWidth and worldHeight as local variables for brevity
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();
        
        spriteBatch.draw(backgroundTexture, 0, 0, worldWidth, worldHeight); // draw the background
        //spriteBatch.draw(bucketTexture, 0, 0, 1, 1); // draw the bucket with width/height of 1 meter in the bottom-left border
        bucketSprite.draw(spriteBatch); // Sprites have their own draw method
        
        spriteBatch.end();
    }
}
