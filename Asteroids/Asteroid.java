
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Asteroid extends GameObject {

    private final Random rand;

    public Asteroid() {

        super(0, 0, "asteroid");
        rand = new Random();
        setPosition(rand.nextDouble() * 540 + 30, 600);
        setRadius(16);
        setTeam(2);
        setVelocity(rand.nextDouble() * 2 - 1, -5);

    }

    public void offBottom() {
        die();
    }

    @Override
    public void offTop() {
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

    @Override
    public void die() {
        new GameObject(getX(), getY(), "explosion");
        super.die();
    }
}
