
import java.util.ArrayList;
import java.util.List;

/**
 * LifeCounter is a GameObject that visually tracks the player's remaining
 * lives. It maintains a list of small GameObject instances representing each
 * life indicator.
 */
public class LifeCounter extends GameObject {

    private final List<GameObject> lifeList;

    /**
     * Constructs a new LifeCounter and initializes the internal list used to
     * track life indicators.
     */
    public LifeCounter() {
        super();
        this.lifeList = new ArrayList<>();
    }

    /**
     * Updates the visual life indicators to match the given number of lives. If
     * there are fewer indicator objects than {@code lives}, new indicators are
     * created and added. If there are more, the excess indicators are removed
     * and marked dead.
     *
     * @param lives the desired number of life indicators to show
     */
    public void update(int lives) {
        // Add indicators until we reach the requested count
        while (lifeList.size() < lives) {
            GameObject life = new GameObject(20 + lifeList.size() * 30, 580, "red");
            lifeList.add(life);
        }

        // Remove excess indicators and mark them dead
        while (lifeList.size() > lives) {
            GameObject life = lifeList.remove(lifeList.size() - 1);
            life.die();
        }

    }

}
