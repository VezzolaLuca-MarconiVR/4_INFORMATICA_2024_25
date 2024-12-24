package io.github.vezzolaluca.aprebottegailprestaorecchio.lwjgl3;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import io.github.vezzolaluca.aprebottegailprestaorecchio.Core;

/** Launches the desktop (LWJGL3) application. */
public class Lwjgl3Launcher {
    public static void main(String[] args) {
        if (StartupHelper.startNewJvmIfRequired()) return; // This handles macOS support and helps on Windows.
        createApplication();
    }

    private static Lwjgl3Application createApplication() {
        return new Lwjgl3Application(new Core(), getDefaultConfiguration());
    }

    private static Lwjgl3ApplicationConfiguration getDefaultConfiguration() {
        Lwjgl3ApplicationConfiguration configuration = new Lwjgl3ApplicationConfiguration();
        
        //ME: Imposta il titolo della nuova finestra che conterrà il gioco.
        configuration.setTitle("Apre Bottega il Prestaorecchio");
        
        //// Vsync limits the frames per second to what your hardware can display, and helps eliminate
        //// screen tearing. This setting doesn't always work on Linux, so the line after is a safeguard.
        //ME: Abilita il Vsync (riduce il numero di FPS per non incombere nello "screen tearing".
        configuration.useVsync(true);
        
        //// Limits FPS to the refresh rate of the currently active monitor, plus 1 to try to match fractional
        //// refresh rates. The Vsync setting above should limit the actual FPS to match the monitor.
        //ME: Imposta un tetto massimo agli FPS (il +1 serve a controbilanciare la possibilità di incombere nell'approssimazione di unità
        //	di refresh rate frazionarie che, per esempio, invece di 60Hz, il programma, facendo una get dall'API, lo leggerebbe come 59Hz)
        configuration.setForegroundFPS(Lwjgl3ApplicationConfiguration.getDisplayMode().refreshRate + 1);
        //// If you remove the above line and set Vsync to false, you can get unlimited FPS, which can be
        //// useful for testing performance, but can also be very stressful to some hardware.
        //// You may also need to configure GPU drivers to fully disable Vsync; this can cause screen tearing.
        
        //ME: Imposta le dimensioni della finestra all'avvio.
        configuration.setWindowedMode(1000, 800);
        
        //// You can change these files; they are in lwjgl3/src/main/resources/ .
        //ME: Imposta le icone della finestra.
        configuration.setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png");
        
        return configuration;
    }
}