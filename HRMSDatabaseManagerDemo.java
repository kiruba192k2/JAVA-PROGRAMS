
class DatabaseManager {

    private static DatabaseManager instance;

    private DatabaseManager() {
        System.out.println("HRMS Database Manager Created");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to HRMS Database");
    }
}

public class HRMSDatabaseManagerDemo {

    public static void main(String[] args) {
        DatabaseManager db1 = DatabaseManager.getInstance();
        DatabaseManager db2 = DatabaseManager.getInstance();
        db1.connect();
        System.out.println("Same Object : " + (db1 == db2));
    }
}
