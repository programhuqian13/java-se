package principle.richterreplacement;

public abstract class Animal {

    private double runSpeed;

    public double getRunSpeed() {
        return runSpeed;
    }

    public void setRunSpeed(double runSpeed) {
        this.runSpeed = runSpeed;
    }

    private double getTime(double distance){
        return (distance/runSpeed);
    }
}
