package dp.buildmode.prototype;

public class ProtoTypeMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();
        Realizetype realizetype1 = (Realizetype) realizetype.clone();
        System.out.println("realizeType == realizeType2 " + (realizetype == realizetype1));
    }

}
