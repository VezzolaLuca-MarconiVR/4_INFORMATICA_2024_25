package vezzolaluca.whisperinggods;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Core extends ApplicationAdapter {      
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
    
    //The three major objects - the MVC pattern
    GameModel gameModel;
    GameView gameView;
    GameController gameController;
    
    @Override
    public void create() {
        //Creating all three parts of the game, following the MVC pattern
        gameModel = new GameModel();
        gameView = new GameView(gameModel, viewport);
        gameController = new GameController(gameModel, gameView);
    }

    @Override
    public void render() {
        //Calling the Controller and View's methods to do the game logic (gameController) and the visualization (gameView)
        gameController.control();
        gameView.draw(gameModel.getSpriteBatch());
    }
    
    @Override
    public void resize (int width, int height) {
        gameModel.getViewport().update(width, height, true); // true centers the camera
    }

    @Override
    public void pause () {
    }

    @Override
    public void resume () {
    }
    
    @Override
    public void dispose() {
        gameModel.dispose();
    }
}
