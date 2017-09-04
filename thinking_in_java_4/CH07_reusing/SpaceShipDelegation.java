/* @UNIVESRE.COM_20170117_HYE
 * Demo: a pattern between composition and inheritance - 代理,
 * ch7.3代理, p131. */

public class SpaceShipDelegation {

    private String name;
    private SpaceShipControls controls = new SpaceShipControls();
    public SpaceShipDelegation(String name) {
        this.name = name;
    }

    // Delegated methods;
    public void up(int velocity) {
        controls.up(velocity);
    }

    public void down(int velocity) {
        controls.down(velocity);
    }

    public void left(int velocity) {
        controls.left(velocity);
    }

    public void right(int velocity) {
        controls.right(velocity);
    }

    public void forward(int velocity) {
        controls.forward(velocity);
    }

    public void back(int velocity) {
        controls.back(velocity);
    }

    public void turboBoost() {
        controls.turboBoost();
    }

    // main();
    public static void main(String[] args) {
        SpaceShipDelegation protector = new SpaceShipDelegation("NSEA Protector");

        // Will finally call controls.forward, that is delegation;
        protector.forward(100);
    }

}



