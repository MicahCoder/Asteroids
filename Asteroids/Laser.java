
public class Laser extends GameObject {

    public static final double SPEED = 10.0;

    public Laser(GameObject parent) {
        super(parent.getX(), parent.getY(), "laser");
        setVelocity(0, SPEED);
        setTeam(parent.getTeam());
    }

    @Override
    public void offScreen() {
        die();
    }
}
