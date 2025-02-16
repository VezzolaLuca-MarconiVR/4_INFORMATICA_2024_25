package vezzolaluca.whisperinggods.controller;

import vezzolaluca.whisperinggods.model.PlayerModel;
import vezzolaluca.whisperinggods.model.GameModel;
import vezzolaluca.whisperinggods.model.Constants;
import vezzolaluca.whisperinggods.view.GameView;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import static vezzolaluca.whisperinggods.model.Constants.CAMERA_HEIGHT;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;
    
    public GameController(GameModel model, GameView view) {
        this.gameModel = model;
        this.gameView = view;
    }

    //Manages the input from the keyboard and mouse (and touch)
    public void manageInput() {
        PlayerModel player = gameModel.getPlayer();
        
        //Player motion
        //Movement
        if (Gdx.input.isKeyPressed(Input.Keys.D) && Constants.MAX_PLAYER_SPEED > gameModel.getPlayerBody().getLinearVelocity().x){
            player.getBody().applyForceToCenter(player.getMovementVector(), true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A) && Constants.MAX_PLAYER_SPEED > -gameModel.getPlayerBody().getLinearVelocity().x){
            player.getBody().applyForceToCenter(-player.getMovementVector().x, 0, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.S) && Constants.MAX_PLAYER_SPEED > -gameModel.getPlayerBody().getLinearVelocity().x){
            player.getBody().applyForceToCenter(0, -10, true);
        }
        
        //Jump
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            player.getBody().applyLinearImpulse(player.getJumpVector(), player.getBody().getPosition(), true); //.getLocalCenter() returns the center of mass so it applies the impulse without any torque
        }
        
        player.setPosition(player.getBody().getPosition().x - player.getWidth()/2, player.getBody().getPosition().y - player.getHeight()/2);
    
        //Repositioning the camera according to the player
        float cameraX = gameModel.getPlayer().getX();
        float cameraY;
        if(gameModel.getPlayer().getY() > CAMERA_HEIGHT/2){
            cameraY = gameModel.getPlayer().getY() + CAMERA_HEIGHT/2;
        }else {
            cameraY = CAMERA_HEIGHT;
        }
        
        gameModel.getPCamera().position.set(cameraX, cameraY, 0);
    }
    
    //Manages the stepping of the physics simulation
    public void managePhysics(){
        float accumulator = 0;
        
        // fixed time step
        // max frame time to avoid spiral of death (on slow devices)
        float frameTime = Math.min(gameModel.getDeltaTime(), 0.25f);
        accumulator += frameTime;
        while (accumulator >= Constants.TIME_STEP) {
            gameModel.getWorld().step(Constants.TIME_STEP, Constants.VELOCITY_ITERATIONS, Constants.POSITION_ITERATIONS);
            accumulator -= Constants.TIME_STEP;
        }
    }
    
    //Manages the actions of all the worl's entities
    public void manageEntitiesActions(){
        gameModel.worldEntityList.doEntitiesActions();
    }
}
