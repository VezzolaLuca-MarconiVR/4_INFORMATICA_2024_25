package vezzolaluca.whisperinggods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class GameController {
    private GameModel gameModel;
    private GameView gameView;
    
    public GameController(GameModel model, GameView view) {
        this.gameModel = model;
        this.gameView = view;
    }

    //Manages the input from the keyboard and mouse (and touch)
    public void manageInput() {
        float delta = gameModel.getDeltaTime();
        PlayerModel player = gameModel.getPlayer();
        float speed = gameModel.getPlayer().getSpeed();

        //Player motion
        if (Gdx.input.isKeyPressed(Input.Keys.D) && Constants.MAX_PLAYER_SPEED > gameModel.getPlayerBody().getLinearVelocity().x){
            gameModel.getPlayerBody().applyForceToCenter(0.5f, 0f, true);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A) && Constants.MAX_PLAYER_SPEED > -gameModel.getPlayerBody().getLinearVelocity().x){
            gameModel.getPlayerBody().applyForceToCenter(-0.5f, 0f, true);
        }

        // Input mouse o touch
        if (Gdx.input.isTouched()) {
            Vector2 touchPos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            gameModel.getViewport().unproject(touchPos);
            player.setPosition(touchPos.x - player.getWidth() / 2, touchPos.y - player.getHeight() / 2);
        }
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
