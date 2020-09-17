package dp.buildmode.prototype;

/**
 使用原型模式生成类似的对象
 */
public class Cication implements Cloneable{

    private String name;

    private String info;

    private String college;

    public Cication(String name, String info, String college) {
        this.name = name;
        this.info = info;
        this.college = college;
        System.out.println("原型类创建成功");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public void display(){
        System.out.println(name + info + college);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        System.out.println("对象复制成功");
        return super.clone();
    }
}
