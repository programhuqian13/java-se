package dp.buildmode.prototype;

import java.util.Scanner;

public class Square implements Shape{


    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return square;
    }

    @Override
    public void countArea() {
        int a = 0;
        System.out.println("这是一个正方形，正方形的边长为：");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        System.out.println("正方形的边长为：" + (a*a));
    }
}
