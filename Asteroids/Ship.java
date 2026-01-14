
import java.util.function.Consumer;

/**
 * Ship represents the player's craft. It handles movement controls, firing
 * lasers, shields (lives), and interactions with power-ups.
 */
public class Ship extends GameObject {

    private double speed = 0.0;
    private double maxSpeed = 10.0;
    private double acceleration = 10.0;
    private int shotsLeft;
    private int shields;
    private final Consumer<Integer> lifeUpdate;
    private final Consumer<Integer> laserUpdate;
    private boolean leftHeld = false;
    private boolean rightHeld = false;

    /**
     * Constructs a new Ship at the given position and registers callbacks for
     * updating UI elements that display lives and lasers.
     *
     * @param x initial x position
     * @param y initial y position
     * @param lifeUpdate consumer called with the current shield count when it
     * changes
     * @param laserUpdate consumer called with the current shots-left count when
     * it changes
     */
    public Ship(int x, int y, Consumer<Integer> lifeUpdate, Consumer<Integer> laserUpdate) {
        super(x, y, "ship2");
        shotsLeft = 10;
        shields = 3;
        getKeyFocus();
        setTeam(1);
        this.lifeUpdate = lifeUpdate;
        this.laserUpdate = laserUpdate;
        lifeUpdate.accept(shields);
        laserUpdate.accept(shotsLeft);
    }

    /**
     * Called when the left movement key is pressed; moves the ship left.
     */
    public void keyLeftPressed() {
        leftHeld = true;
    }

    public void keyLeftReleased() {
        leftHeld = false;
    }

    /**
     * Called when the right movement key is pressed; moves the ship right.
     */
    public void keyRightPressed() {
        rightHeld = true;
    }

    public void keyRightReleased() {
        rightHeld = false;
    }

    /**
     * Fires a Laser if there are shots left and updates the laser counter UI.
     */
    public void keySpacePressed() {
        if (shotsLeft < 1) {
            return;
        }
        new Laser(this, speed);
        shotsLeft--;
        laserUpdate.accept(shotsLeft);
    }

    /**
     * Handle collision with another GameObject. If a power-up is active, ignore
     * collisions. If shields remain, decrement shields and notify UI; otherwise
     * defer to the superclass collision behavior.
     *
     * @param other the other GameObject involved in the collision
     */
    @Override
    public void collision(GameObject other) {
        if (Powerup.powerupActive) {
            return;
        }
        if (shields > 0) {
            shields--;
            lifeUpdate.accept(shields);
            other.die();
            return;
        }
        super.collision(other);
    }

    /**
     * Apply the power-up effect: refill shots and switch to powered sprite.
     */
    public void powerUp() {
        shotsLeft = 20;
        setSprite("ship4");
        laserUpdate.accept(shotsLeft);

    }

    /**
     * Revert any power-up visual effects (switch back to normal sprite).
     */
    public void powerDown() {
        setSprite("ship2");
    }

    /**
     * Called each frame to update ship state; ensures power-up state is applied
     * or removed appropriately.
     */
    @Override
    public void step() {
        super.step();
        if (Powerup.powerupActive) {
            powerUp();
        } else {
            powerDown();
        }

        if (leftHeld) {
            speed -= acceleration / Game.FPS;
        }
        if (rightHeld) {
            speed += acceleration / Game.FPS;

        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
        }
        if (speed < -maxSpeed) {
            speed = -maxSpeed;
        }
        setVelocity(speed, 0);
    }
}
