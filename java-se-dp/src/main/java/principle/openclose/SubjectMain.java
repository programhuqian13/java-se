package principle.openclose;


import principle.openclose.interfaces.SubInterSubject1;
import principle.openclose.interfaces.SubInterSubject2;
import principle.openclose.subject.AbstractSubject;
import principle.openclose.subject.SubSubject1;
import principle.openclose.subject.SubSubject2;

public class SubjectMain {

    public static void main(String[] args) {
        AbstractSubject abstractSubject = new SubSubject1();
        abstractSubject.display();

        AbstractSubject abstractSubject1 = new SubSubject2();
        abstractSubject1.display();

        principle.openclose.interfaces.AbstractSubject abstractSubject2 = new SubInterSubject1();
        abstractSubject2.display();

        principle.openclose.interfaces.AbstractSubject abstractSubject3 = new SubInterSubject2();
        abstractSubject3.display();
    }
}
