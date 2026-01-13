
import java.util.ArrayList;
import java.util.List;

/**
 * LaserCounter is a GameObject that visually tracks the number of available
 * lasers. It maintains a list of small GameObject instances representing each
 * laser indicator.
 */
public class LaserCounter extends GameObject {

    private final List<GameObject> laserList;

    /**
     * Constructs a new LaserCounter. Initializes the internal list used to
     * track laser indicators.
     */
    public LaserCounter() {
        super();
        this.laserList = new ArrayList<>();
    }

    /**
     * Updates the visual laser indicators to match the given number of lives.
     * If the current number of indicator objects is less than {@code lives},
     * new GameObject indicators are created and added. If there are more
     * indicators than {@code lives}, excess indicators are removed and marked
     * dead.
     *
     * Note: Indicators are positioned differently depending on how many exist
     * so they wrap to a second column after 10 items.
     *
     * @param lives the desired number of laser indicators to show
     */
    public void update(int lives) {
        // Add indicators until we reach the requested count
        while (laserList.size() < lives) {
            GameObject life;
            // Position in second column when more than 10
            if (laserList.size() > 10) {
                life = new GameObject(580, laserList.size() * 30, "green");
            } else {
                life = new GameObject(550, (laserList.size() - 10) * 30, "green");
            }

            laserList.add(life);
        }

        // Remove excess indicators and mark them dead
        while (laserList.size() > lives) {
            GameObject life = laserList.remove(laserList.size() - 1);
            life.die();
        }

    }

}
