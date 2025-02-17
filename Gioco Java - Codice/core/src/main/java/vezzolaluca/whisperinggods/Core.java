package vezzolaluca.whisperinggods;

import vezzolaluca.whisperinggods.controller.GameController;
import vezzolaluca.whisperinggods.model.GameModel;
import vezzolaluca.whisperinggods.view.GameView;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.physics.box2d.Box2D;
import static vezzolaluca.whisperinggods.model.Constants.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Core extends ApplicationAdapter {      
    /*
     * Sounds that are <10 seconds should be a Sound object, the rest is a Music
     * (by using a Music object the sound is streamed and not stored in RAM as a whole).
     */
    Sound dropSound;
    Music music;
    
    //The three major objects - the MVC pattern
    GameModel gameModel;
    GameView gameView;
    GameController gameController;
    
    @Override
    public void create() {
        Box2D.init(); //Initializin ìg Box2D, otherwise the natives won't be loaded before the world gets loaded
        
        //Creating all three parts of the game, following the MVC pattern
        gameModel = new GameModel();
        gameView = new GameView(gameModel);
        gameController = new GameController(gameModel, gameView);
    }

    @Override
    public void render() {
        //Calling the Controller and View's methods to do the game logic (gameController) and the visualization (gameView)
        gameController.manageInput();
        gameView.draw(gameModel.getSpriteBatch());
        gameController.managePhysics();
        gameController.manageEntitiesActions();
    }
    
    @Override
    public void resize (int width, int height) {
        //gameModel.getViewport().update(width, height, true); // true centers the camera
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
