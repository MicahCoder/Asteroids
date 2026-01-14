
import java.util.Random;

/**
 * Asteroid represents an enemy object that drifts downward and may collide with
 * the player's ship or lasers. It chooses a random sprite, position, and
 * initial velocity when created.
 */
public class Asteroid extends GameObject {

    private final Random rand;
    private final static String[] sprites = {
        "smallAsteroid", "asteroid", "midAsteroid", "bigAsteroid"
    };

    /**
     * Constructs a new Asteroid with a random sprite, position near the top of
     * the screen, and a random horizontal velocity.
     */
    public Asteroid() {

        super(0, 0, "asteroid");
        rand = new Random();
        setSprite(sprites[rand.nextInt(4)]);
        setPosition(rand.nextDouble() * 540 + 30,
                600);
        setRadius(16);
        setTeam(2);
        setVelocity(rand.nextDouble() * 2 - 1, -5);

    }

    /**
     * Called when the asteroid moves off the bottom of the screen; remove it.
     */
    public void offBottom() {
        die();
    }

    /**
     * Called when the asteroid moves off the top of the screen. Intentionally
     * left empty because asteroids never move up past the top in normal play.
     */
    @Override
    public void offTop() {
    }

    /**
     * Handle collision with another GameObject. Collisions are probabilistic;
     * only a fraction of collisions will result in the asteroid actually
     * interacting (this provides some randomness in gameplay).
     *
     * @param other the other object involved in the collision
     */
    @Override
    public void collision(GameObject other) {
        if (rand.nextDouble() > 0.34) {
            return;
        }
        super.collision(other);
    }

    // @Override
    // public void draw(Graphics g) {
    //     super.draw(g);
    //     drawCircle(g, Color.YELLOW);
    // }
    /**
     * When an asteroid dies, spawn an explosion object at its location and then
     * perform default die behavior.
     */
    @Override
    public void die() {
        new GameObject(getX(), getY(), "explosion");
        super.die();
    }
}
