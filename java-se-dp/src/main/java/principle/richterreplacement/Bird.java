package principle.richterreplacement;


public class Bird extends Animal {

    private double flySpeed;

    public double getFlySpeed() {
        return flySpeed;
    }

    public void setFlySpeed(double flySpeed) {
        this.flySpeed = flySpeed;
    }

    public double getFlyTime(double bounce){
        return (bounce/flySpeed);
    }
}
