
import java.lang.*;

@SuppressWarnings("unused")
class Emptyclass {

}

public class Reflection {

    public static void main(String[] args) {
        Emptyclass e = new Emptyclass();
        Class<?> c = e.getClass();
        System.out.println("Class Name: " + c.getName());
    }

}
