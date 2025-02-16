package vezzolaluca.whisperinggods.model;

//A class for alla of the constants of the game
public class Constants {
    //The aspect ratio is constant (16:9)
    public static final int INITIAL_WINDOW_WIDTH = 1920, INITIAL_WINDOW_HEIGHT = 9*INITIAL_WINDOW_WIDTH/16; //In pixels
    public static final float VIEWPORT_WIDTH = 32f, VIEWPORT_HEIGHT = 9*VIEWPORT_WIDTH/16; //In meters
    
    public static final float CAMERA_WIDTH = 16f;
    public static final float CAMERA_HEIGHT = 9f;
    
    public static final float TIME_STEP = 1/90f; // Time step per la simulazione fisica
    public static final int VELOCITY_ITERATIONS = 6; // Numero di iterazioni di velocità ad ogni step
    public static final int POSITION_ITERATIONS = 2; // Numero di iterazioni di posizione ad ogni step
    
    public static final float MAX_PLAYER_SPEED = 7; //Player's maximum horizontal velocity
}