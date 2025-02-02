package vezzolaluca.whisperinggods;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
    //An AssetManager stores all of the assets needed
    public static final AssetManager manager = new AssetManager();
    
    //Here you declare all of the filenames of the assets to use inside the game
    public static final String BUCKET_TEXTURE = "bucket.png";
    public static final String BACKGROUND_TEXTURE = "background.png";

    public static void load() {
        //Assets can be loaded by passing their filename and "container" class
        manager.load(BUCKET_TEXTURE, Texture.class);
        manager.load(BACKGROUND_TEXTURE, Texture.class);
        
        //Waits until all the assets are loaded
        manager.finishLoading();
    }

    public static void dispose() {
        manager.dispose();
    }
}
