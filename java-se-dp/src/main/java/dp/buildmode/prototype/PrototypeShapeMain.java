package dp.buildmode.prototype;

public class PrototypeShapeMain {

    public static void main(String[] args) {
        PrototypeManager prototypeManager = new PrototypeManager();
        Circle circle = (Circle) prototypeManager.getShape("Circle");
        circle.countArea();
        Square square = (Square) prototypeManager.getShape("Square");
        square.countArea();
    }
}
