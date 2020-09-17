package dp.buildmode.prototype;

public class CicationMain {

    public static void main(String[] args) throws CloneNotSupportedException {
        Cication cication = new Cication("tony","由于表现优异，获得荣誉证书","XX公司");
        cication.display();
        Cication cication1 = (Cication) cication.clone();
        cication1.setName("tony smith");
        cication1.display();
    }

}
