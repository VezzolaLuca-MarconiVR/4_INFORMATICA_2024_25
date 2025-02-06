package vezzolaluca.whisperinggods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

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
            player.getBody().applyForceToCenter(player.getMovementVector(), true);
        }
//        //Jump
//        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
//            player.getBody().applyLinearImpulse(player.getJumpVector(), player.getBody().getLocalCenter(), true); //.getLocalCenter() returns the center of mass so it applies the impulse without any torque
//        }
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
}
