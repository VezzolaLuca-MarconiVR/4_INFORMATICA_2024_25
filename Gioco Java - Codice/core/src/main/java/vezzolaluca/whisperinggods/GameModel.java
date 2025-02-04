package vezzolaluca.whisperinggods;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameModel {
    private PlayerModel player;
    private SpriteBatch spriteBatch;
    private FitViewport viewport;
    private Vector2 touchPos; //Vector for mouse/touch input
    
    public GameModel() {
        AssetLoader.load();
        Texture playerTexture = AssetLoader.manager.get(AssetLoader.BUCKET_TEXTURE, Texture.class);
        
        //Initialize the player's texture and position (sprite)
        player = new PlayerModel(playerTexture, 1, 1, 1, 1);
        
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8, 5);
        
        
        touchPos = new Vector2();
    }

    public PlayerModel getPlayer() {
        return player;
    }
    
    //returns the used viewport (Viewport is the parent class of all viewports)
    public Viewport getViewport(){
        return this.viewport;
    }
    
    public SpriteBatch getSpriteBatch(){
        return this.spriteBatch;
    }
    
    public void dispose(){
        AssetLoader.dispose();
        spriteBatch.dispose();
    }
}
