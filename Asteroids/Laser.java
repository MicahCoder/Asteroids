
/**
 * Laser represents a projectile fired by the Ship. It moves at constant
 * vertical speed and is removed when it goes off-screen.
 */
public class Laser extends GameObject {

    public static final double SPEED = 10.0;

    /**
     * Constructs a Laser positioned at the parent object's location and sets
     * its velocity and team to match the parent (so it interacts
     * appropriately).
     *
     * @param parent the GameObject that fired this Laser
     */
    public Laser(GameObject parent, double ySpeed) {
        super(parent.getX(), parent.getY(), "laser");
        setVelocity(ySpeed, SPEED);
        setTeam(parent.getTeam());
    }

    /**
     * Called when the Laser moves off-screen; removes it from the game.
     */
    @Override
    public void offScreen() {
        die();
    }
}
