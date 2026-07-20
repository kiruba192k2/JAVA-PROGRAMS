
class emp {

    int id = 101;
}

public class Garbagecollection {

    public static void main(String[] args) {
        emp e = new emp();
        e = null;
        System.gc();
        System.out.println("employee obj eligible for garbage collection");
    }
}
