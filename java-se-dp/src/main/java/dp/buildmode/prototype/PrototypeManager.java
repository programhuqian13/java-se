package dp.buildmode.prototype;

import java.util.HashMap;

public class PrototypeManager {

    private HashMap<String,Shape> shape = new HashMap<>();

    public PrototypeManager(){
        shape.put("Circle",new Circle());
        shape.put("Square",new Square());
    }

    public void addShape(String key,Shape shape){
        this.shape.put(key,shape);
    }

    public Shape getShape(String key){
        Shape shape = this.shape.get(key);
        return (Shape) shape.clone();
    }

}
