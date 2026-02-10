import java.util.Scanner;

class Emp {
    double salary;
    Emp(double salary) {
        this.salary=salary;
    }

    void display() {
        System.out.println("salary: " +salary);
    }
}

class FullTimeEmp extends Emp {
    FullTimeEmp(double salary) {
        super(salary);
    }

    void calcsalary() {
        salary=salary*1.50;
    }
}

class Intern extends Emp {
    Intern(double salary) {
        super(salary);
    }

    void calcsalary() {
        salary=salary*1.25;
    }
}

public class MPJLab2 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.print("enter full time emp salary: ");
        double ftesalary=sc.nextDouble();

        FullTimeEmp fte=new FullTimeEmp(ftesalary);
        System.out.println("\nfull time emp: ");
        System.out.print("before hike: ");
        fte.display();
        fte.calcsalary();
        System.out.print("after hike: ");
        fte.display();

        System.out.println();

        System.out.print("\nenter intern salary: ");
        double internsalary=sc.nextDouble();
        Intern intern=new Intern(internsalary);
        System.out.println("\nintern emp: ");
        System.out.print("before hike: ");
        intern.display();
        intern.calcsalary();
        System.out.print("after hike: ");
        intern.display();

        sc.close();
    }
}
