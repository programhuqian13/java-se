package templatemethod;

public abstract class TemplateMethod2 {

    public void tempalteMethod(){
        abstractMethod();
        hookMethod();
        conMthod();
    }

    protected abstract void abstractMethod();

    protected void hookMethod(){

    }

    private final void conMthod(){
        System.out.println("conMthod show ");
    }

}
