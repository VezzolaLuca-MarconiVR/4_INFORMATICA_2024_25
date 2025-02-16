package vezzolaluca.whisperinggods.view;

import vezzolaluca.whisperinggods.model.PhisicalEntity;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import vezzolaluca.whisperinggods.controller.AssetLoader;
import vezzolaluca.whisperinggods.model.Entity;
import vezzolaluca.whisperinggods.model.GameModel;

public class GameView {
    private GameModel gameModel;
    
    public GameView(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public void draw(SpriteBatch spriteBatch) {
        gameModel.getPCamera().update();
        /*
         * It’s a good practice to clear the screen every frame.
         * Otherwise, you’ll get weird graphical errors. You can use any color you want.
         */
        ScreenUtils.clear(Color.BLACK);
        
        //From now on the FitViewport object "viewport" will be used
        //gameModel.getViewport().apply();
        //gameModel.getViewport().setCamera(gameModel.getPCamera());
        //Shows how the Viewport is applied to the SpriteBatch. This is necessary for the images to be shown in the correct place.
        spriteBatch.setProjectionMatrix(gameModel.getPCamera().combined);
        
        
        spriteBatch.begin();//add all of the lines for drawing in here, between spriteBatch.begin() and spriteBatch.end()
        /*
         * The coordinates we provide determine where the textures will be drawn on the screen.
         * The coordinates begin in the bottom left and grow to the right and up.
         * Our game world is described in imaginary units best defined as meters.
         * 
         * For simplicity, 100 pixels will equal 1 meter.
         * This ratio of pixels per meter can be anything you want, but make sure whatever you choose is a simple value that
         * makes sense in your game world. This is typically the size of your tiles or the height of the player character.
         * 
         * Your game logic should really know nothing about pixels.
         */
        
        //Drawing the background
        //Obtain the background's texture from the asset manager and add it to the spriteBatch
        spriteBatch.draw(AssetLoader.manager.get(AssetLoader.BACKGROUND_TEXTURE, Texture.class), 0, 0, gameModel.getPCamera().viewportWidth, gameModel.getPCamera().viewportHeight); // draw the background

        //Drawing all of the world's entities
        for(Entity e : gameModel.worldEntityList.getAllEntities()){
            if(e.getClass() == PhisicalEntity.class){
                PhisicalEntity pE = (PhisicalEntity) e;
                pE.updatePositionAccordingToBody();
            }
            e.draw(spriteBatch);
        }
        
        //Drawing the player
        spriteBatch.draw(gameModel.getPlayer().getTexture(), gameModel.getPlayer().getX(), gameModel.getPlayer().getY(), gameModel.getPlayer().getWidth(), gameModel.getPlayer().getHeight());
        
        spriteBatch.end();//Closes the spriteBatch
        
        gameModel.getDebugRenderer().render(gameModel.getWorld(), gameModel.getPCamera().combined);
    }
}
