package io.github.vezzolaluca.aprebottegailprestaorecchio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Core extends ApplicationAdapter {
    
	//ME: Una texture è un'immagine (e.g. in PNG) decodificata e immagazzinata nella RAM
	// (verrà poi passata alla GPU per il rendering).
	private Texture callicarpa;
    
    //ME: Uno SpriteBatch è un buffer che contiene tutte le geometrie (che si susseguono)
    // da applicare ad una stessa texture, per minimizzare i caricamenti di texture identiche.
    private SpriteBatch spriteBatch;
    
    //ME: Una FItViweport è un contenitore (e.g. un div) che rimane delle stesse dimensioni quando
    // la finestra è ridimensionata (nel metodo resize si aggiorna la viewport per
    // ridimensionarla in concordanza con la finestra)
    private FitViewport viewport;
    
    //ME: per testare:
    float velocita = .05f;
    float callicarpaX = 0f;
    float callicarpaY = 0f;

    @Override
    public void create() {
        callicarpa = new Texture("callicarpa_full.png");
        
        spriteBatch = new SpriteBatch();

        //ME: I parametri sono la larghezza e l'altezza della viewport, che non corrispondono a pixel ma a "metri" (non in scala reale).
        viewport = new FitViewport(8f, 5f);
    }

    @Override
    public void render() {
    	
    	//ME: Il codice per il rendering è così strutturato:
    	input();
        logic();
        draw();
    }
    
    @Override
	public void resize (int width, int height) {
    	//ME: Ridimensiona anche la viewport (true centra la vista).
    	viewport.update(width, height, true);
	}

    @Override
    public void dispose() {
        
    }
    
    private void input() {
    	if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            callicarpaY += velocita;
        }
    	if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            callicarpaX -= velocita;
        }
    	if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            callicarpaY -= velocita;
        }
    	if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            callicarpaX += velocita;
        }
    }
    
    private void logic() {
    	
    }
    
    private void draw() {
    	ScreenUtils.clear(Color.FOREST);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        spriteBatch.draw(callicarpa, callicarpaX, callicarpaY, 1, 1);
        
        spriteBatch.end();
    }
}
