package dp.buildmode.prototype;

import java.util.Scanner;

public class Circle implements Shape{

    @Override
    public Object clone() {
        Circle w = null;
        try {
            w = (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return w;
    }

    @Override
    public void countArea() {
        int r = 0;
        System.out.println("这是一个圆的半径，请输入圆的半径：");
        Scanner scanner = new Scanner(System.in);
        r = scanner.nextInt();
        System.out.println("圆的面积的为：" + (Math.PI * r * r));
    }
}
