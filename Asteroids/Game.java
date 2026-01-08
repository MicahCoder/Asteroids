

/*
 * Created on Nov 10, 2004
 * for BLA Computer Programming, 2004-2005
 * (asteroids)
 */
import java.util.Random;

/**
 * The Game class contains the static methods restart() and step(), which
 * describe what needs to happen when a new game starts, and during each frame
 * of a game. You can use the step() method to program in things like the
 * appearance of asteroids that need to happen wiht certain timing. A new game
 * is always begun by the creation of a new Game object, so that that Game's
 * step() is called first out of all objects.
 */
public class Game extends GameObject {

    private final static int FPS = 20;
    private final Random a;

    /*
     * A game is constructed once, at the very start of each game.
     */
    public Game() {
        super(); // The game is an invisible object
        a = new Random();
        new Ship(300, 30);
        // Now, when keys are pressed, the methods this object has for
        // dealing with those keys will be called.
    }

    @Override
    public void step() {
        super.step();
        if (a.nextDouble() < 2.0 / FPS) {
            GameObject asteroid = new Asteroid();
        }
    }

}
