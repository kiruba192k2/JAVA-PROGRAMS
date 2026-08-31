
class HRMSConfigManager {

    private static HRMSConfigManager instance;

    private HRMSConfigManager() {
        System.out.println("HRMS Configuration created");
    }

    public static HRMSConfigManager getInstance() {
        if (instance == null) {
            instance = new HRMSConfigManager();
        }
        return instance;
    }

    public void showCompanyName() {
        System.out.println("Company Name  :ABC Technology");
    }

    public void DatabaseName() {
        System.out.println("Database Name :Employee Datas");
    }

    public void ShowVersion() {
        System.out.println("Version       :12.1");
    }
}

public class HRMSConfigManagernDemo {

    public static void main(String[] args) {
        HRMSConfigManager HR1 = HRMSConfigManager.getInstance();
        HRMSConfigManager HR2 = HRMSConfigManager.getInstance();
        HRMSConfigManager HR3 = HRMSConfigManager.getInstance();
        HR1.showCompanyName();
        HR1.DatabaseName();
        HR1.ShowVersion();
        System.out.println("Same object   :" + (HR1 == HR2 && HR1 == HR3 && HR2 == HR3));
    }
}
