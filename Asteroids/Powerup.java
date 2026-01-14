
import java.util.Random;

/**
 * Powerup represents a moving power-up object in the game world. When collected
 * or destroyed it activates a global power-up state for a duration.
 */
public class Powerup extends GameObject {

    public static boolean powerupActive = true;
    public static int powerupTicker = 0;
    private static final double speed = 10.0;
    private final Random rand;
    private final Ship ship;

    /**
     * Constructs a new Powerup at the given coordinates and assigns it to the
     * provided ship (used to respawn a new powerup when one dies).
     *
     * @param x initial x position
     * @param y initial y position
     * @param ship reference to the Ship for potential respawn
     */
    public Powerup(double x, double y, Ship ship) {
        super(x, y, "blue");
        setRadius(10);
        rand = new Random();
        double theta = rand.nextDouble() * 2 * Math.PI;
        // Give the powerup a random initial velocity
        setVelocity(Math.cos(theta) * speed, Math.sin(theta) * speed);
        setTeam(2);
        this.ship = ship;
    }

    /**
     * Advances the global power-up ticker by one frame; when it reaches zero,
     * the power-up effect becomes inactive.
     */
    public static void tickPowerup() {
        if (powerupTicker > 0) {
            powerupTicker--;
        } else {
            powerupActive = false;
        }
    }

    /**
     * Activates the power-up for the given number of seconds.
     *
     * @param time duration in seconds to enable the power-up
     */
    public static void powerUp(int time) {
        powerupActive = true;
        powerupTicker = Game.FPS * time;
    }

    /**
     * When the powerup is destroyed, trigger the effect for a fixed time, call
     * the superclass die behavior, and spawn a new powerup instance.
     */
    @Override
    public void die() {
        powerUp(5);
        super.die();
        new Powerup(200, 200, ship);
    }
}
