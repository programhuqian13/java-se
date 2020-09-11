package principle.richterreplacement;

public class AnimalMain {

    public static void main(String[] args) {
        Bird bird = new Swallow();
        bird.setFlySpeed(100);
        System.out.println("swallow fly speed:" + bird.getFlyTime(300) + "");
        Animal animal = new BrownKiwi();
        animal.setRunSpeed(10);
        System.out.println("brownkiwi run speed:" + bird.getFlyTime(300) + "");
    }

}
