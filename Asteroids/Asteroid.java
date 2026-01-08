
import java.util.Random;

public class Asteroid extends GameObject {

    private final Random rand;

    public Asteroid() {

        super(0, 0, "asteroid");
       rand = new Random();
       setPosition(rand.nextDouble() * 540 + 30, 570);
       setRadius(16);
        setTeam(2);
        setVelocity(0, -5);

    }

    public void offScreen() {
        die();
    }
}
