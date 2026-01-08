
public class Ship extends GameObject {

    private static final double SPEED = 5.0;
    private int shotsLeft;
    private int shields;

    public Ship(int x, int y) {
        super(x, y, "ship");
        shotsLeft = 20;
        shields = 3;
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
        if (shotsLeft < 1) {
            return;
        }
        new Laser(this);
        shotsLeft--;
    }

    @Override
    public void collision(GameObject other) {
        if (shields > 0) {
            shields--;
            return;
        }
        super.collision(other);
    }
}
