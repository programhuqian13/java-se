package templatemethod;


/***
 * java 模板方法
 * 子类可以置换掉父类的可变部分，但是子类却不可以改变模板方法所代表的顶级逻辑。
 */
public class TemplateMethod {

    public final void println(String message){
        System.out.println("##########################");
        warpPrint(message);
        System.out.println("##########################");
    }

    protected void warpPrint(String message){
    }

    public static void main(String[] args) {
        TemplateMethod templateMethod = new TemplateMethod(){

            @Override
            protected void warpPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };

        templateMethod.println("hello world");
    }

}
