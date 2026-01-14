

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

    public final static int FPS = 20;
    private double spawnRate = 0.0;
    private double spawnAcceleration = .1;
    private final Random a;

    /**
     * Constructs the Game instance, creates and wires together global UI
     * components (life/laser counters) and the player's Ship and initial
     * Powerup. This runs once at the start of each game.
     */
    public Game() {
        super(); // The game is an invisible object

        a = new Random();
        LifeCounter lifeCounter = new LifeCounter();
        LaserCounter laserCounter = new LaserCounter();
        Ship ship = new Ship(300, 30, lives -> lifeCounter.update(lives),
                lasers -> laserCounter.update(lasers));
        new Powerup(200, 200, ship);
        // Now, when keys are pressed, the methods this object has for
        // dealing with those keys will be called.
    }

    /**
     * Called once per frame; advances the power-up ticker and occasionally
     * spawns a new Asteroid with a probabilistic rate determined by FPS.
     */
    @Override
    public void step() {
        super.step();
        Powerup.tickPowerup();
        //Acelerates the rate of asteroid creation. 
        spawnRate += spawnAcceleration / FPS;
        if (a.nextDouble() < spawnRate / FPS) {
            GameObject asteroid = new Asteroid();
        }
    }

}
