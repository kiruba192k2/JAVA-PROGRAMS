
import java.lang.reflect.Constructor;

class Employee_ConstructorDemo {

    public Employee_ConstructorDemo() {
    }

    public Employee_ConstructorDemo(String name) {
    }
}

public class Constructorinspection {

    public static void main(String[] args) {
        Constructor<?>[] constructors = Employee_ConstructorDemo.class.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
