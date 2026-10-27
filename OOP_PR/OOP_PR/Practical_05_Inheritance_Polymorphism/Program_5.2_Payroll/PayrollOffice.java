abstract class Employee
{
    String name;
    int id;

    Employee(String name, int id)
    {
        this.name = name;
        this.id = id;
    }

    abstract double monthlysalary();
};

class Fulltime extends Employee
{
    double salary;

    Fulltime(String name, int id, double monthlysalary)
    {
        super(name, id);
        this.salary = monthlysalary;
    }

    @Override
    double monthlysalary() {
        return salary;
    }
};

class Parttime extends Employee
{
    int h, r;

    Parttime(String name, int id, int hours, int rate)
    {
        super(name, id);
        this.h = hours;
        this.r = rate;
    }

    @Override
    double monthlysalary() {
        return h * r;
    }
};

class intern extends Employee
{
    double stipend;

    intern(String name, int id, double Stipend)
    {
        super(name, id);
        this.stipend = Stipend;
    }

    @Override
    double monthlysalary() {
        return stipend;
    }
};

public class PayrollOffice
{
    public static void main(String[] args)
    {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int count = input.nextInt();

        Employee[] employees = new Employee[count];

        for (int i = 0; i < count; i++)
        {
            System.out.println("Employee " + (i + 1) + " type (1=Fulltime, 2=Parttime, 3=Intern): ");
            int type = input.nextInt();

            System.out.print("Enter employee name: ");
            String name = input.next();

            System.out.print("Enter employee ID: ");
            int id = input.nextInt();

            switch (type)
            {
                case 1:
                    System.out.print("Enter monthly salary: ");
                    employees[i] = new Fulltime(name, id, input.nextDouble());
                    break;

                case 2:
                    System.out.print("Enter hours worked: ");
                    int hours = input.nextInt();
                    System.out.print("Enter hourly rate: ");
                    int rate = input.nextInt();
                    employees[i] = new Parttime(name, id, hours, rate);
                    break;

                case 3:
                    System.out.print("Enter stipend: ");
                    employees[i] = new intern(name, id, input.nextDouble());
                    break;

                default:
                    System.out.println("Invalid employee type. Please enter 1, 2, or 3.");
                    i--;
            }
        }

        double totalSalary = 0;

        for (Employee a : employees)
        {
            System.out.println("Class name :- " + a.getClass().getSimpleName());
            System.out.println("Employee type :- " + a.monthlysalary());
            System.out.println("Employee Name :- " + a.name);
            System.out.println("Employee ID :- " + a.id);
            totalSalary = totalSalary + a.monthlysalary();
            System.out.println();

            if (a instanceof intern)
            {
                System.out.println("This is a Intern Employee :- " + a.name);
            }
        }

        System.out.println("Total Salary :- " + totalSalary);

        input.close();
    }
}
