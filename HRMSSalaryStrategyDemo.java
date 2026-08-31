interface SalaryCalculation
{
    double calculateSalary();
}
class PermanentSalary implements SalaryCalculation
{
    public double calculateSalary()
    {
        return 50000;
    }
}
class ContractSalary implements SalaryCalculation
{
    public double calculateSalary()
    {
        return 30000;
    }
}
class EmployeeSalaryProcessor
{
    private SalaryCalculation strategy;
    public EmployeeSalaryProcessor(SalaryCalculation strategy)
    {
        this.strategy = strategy;
    }
    public void processSalary()
    {
        System.out.println("Salary : " + strategy.calculateSalary());
    }
}
public class HRMSSalaryStrategyDemo
{
    public static void main(String[] args)
    {
        SalaryCalculation strategy = new PermanentSalary();
        EmployeeSalaryProcessor processor =new EmployeeSalaryProcessor(strategy);
        processor.processSalary();
    }
}

