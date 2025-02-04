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

    public void control() {
        float speed = 4f;
        float delta = Gdx.graphics.getDeltaTime();
        PlayerModel player = gameModel.getPlayer();

        //Keyboard movement
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            player.moveX(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            player.moveX(-speed * delta);
        }

        // Input mouse o touch
        if (Gdx.input.isTouched()) {
            Vector2 touchPos = new Vector2(Gdx.input.getX(), Gdx.input.getY());
            gameModel.getViewport().unproject(touchPos);
            player.setPosition(touchPos.x - player.getWidth() / 2, touchPos.y - player.getHeight() / 2);
        }
        
    }
}
