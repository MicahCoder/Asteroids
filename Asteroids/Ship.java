
public class Ship extends GameObject {

    private static final double SPEED = 5.0;

    public Ship(int x, int y) {
        super(x, y, "ship");
        getKeyFocus();
        setTeam(1);
    }

    public void keyLeftPressed() {
        setVelocity(-SPEED, 0);
    }

    public void keyLeftReleased() {
        setVelocity(0, 0);
    }

    public void keyRightPressed() {
        setVelocity(SPEED, 0);
    }

    public void keyRightReleased() {
        setVelocity(0, 0);
    }

    public void keySpacePressed() {
        new Laser(this);
    }
}
