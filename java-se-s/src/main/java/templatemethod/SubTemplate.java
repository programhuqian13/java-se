package templatemethod;


public class SubTemplate extends TemplateMethod2{

    @Override
    protected void abstractMethod() {
        System.out.println("abstractMethod show");
    }

    @Override
    protected void hookMethod() {
        System.out.println("hookMethod show");
    }

    public static void main(String[] args) {
        SubTemplate subTemplate = new SubTemplate();

        subTemplate.tempalteMethod();
    }
}
