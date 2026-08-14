
import java.lang.*;
import java.lang.reflect.*;

@SuppressWarnings("unused")
class etho1 {

    private int eid = 101;
    private String name = "A";
    private double sal = 25000.00;

    void getint() {
        System.out.println("Eid: " + eid);
    }

    int setint(int eid) {
        return this.eid = eid;
    }

}

public class ReflectionFields {

    public static void main(String[] args) {
        Class<etho1> c = etho1.class;
        Field[] fs = c.getDeclaredFields();

        for (Field fs1 : fs) {
            System.out.println(fs1.getName());

        }

        Method[] m = c.getDeclaredMethods();
        for (Method m1 : m) {
            System.out.println(m1.getName());

        }
    }

}
