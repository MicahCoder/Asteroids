
import java.awt.Color;
import java.awt.Graphics;
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

    @Override
    public void collision(GameObject other) {
        if (rand.nextDouble() > 0.34) {
            return;
        }
        super.collision(other);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        drawCircle(g, Color.YELLOW);
    }
}
