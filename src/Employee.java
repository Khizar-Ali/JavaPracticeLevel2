import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Employee {
    private int id;
    private String name;
    private double noOfHours;
    private double salary;


    public Employee() {
        id = 0;
        name = " ";
        noOfHours = 0;
        salary = 0;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setNoOfHours(double noOfHours) {
        this.noOfHours = noOfHours;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee getInfo(int id, String name, double noOfHours, double salary) {
        this.setId(id);
        this.setName(name);
        this.setNoOfHours(noOfHours);
        this.setSalary(salary);
        return this;

    }

    public double addSal() {
        if (salary < 500) {
            salary = salary + 10;
        }
        return salary;
    }

    public double addWork() {
        if (noOfHours > 6) {
            salary = salary + 5;
        }
        return salary;
    }

    public String toString() {
        return "Id :" + this.id + "\nName :" + this.name + "\nSalary: " + this.salary + "\nNo of Hours: " + this.noOfHours;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

        // Generating Random Number for Employee ID:
        Random rand = new Random(); //instance of random class
        int upperbound = 25;
        //generate random values from 0-24
        int empId = rand.nextInt(upperbound);

        int input = 5;
        while (input != 0) {
            if (employeeList.isEmpty()) {
                System.out.println("You do not have any Employee Data. \nEnter Employee Details \n-----------------");
                input = 1;
            } else {
                System.out.print("\nEnter 1 to Add New Employee\nEnter 2 to Add $10 to Salary \nEnter 3 to Add $5 to Salary" +
                        "\nEnter 4 to Print all the Employee data\nEnter 5 to Print the Details using ID\nEnter 0 to exit the program. ");
                input = scan.nextInt();
            }
            switch (input) {
                case 1:
                    System.out.print("Enter Your Name: ");
                    String Name = scan.next();
                    System.out.print("Enter Your Salary: ");
                    double Salary = scan.nextDouble();
                    System.out.print("Enter Your Hours: ");
                    float Hours = scan.nextFloat();
                    Employee emp = new Employee();
                    employeeList.add(emp.getInfo(empId, Name, Hours, Salary));
                    break;

                case 2:
                    if (!(employeeList.isEmpty())) {
                        System.out.print ("Enter Your ID: ");
                        int searchId = scan.nextInt ();
                        for (Employee p : employeeList){
                            if (searchId ==p.id){
                                p.addSal ();
                                System.out.println (p);
                            }
                        }
                    } else {
                        System.out.println("Your list is empty");
                    }
                    break;
                case 3:
                    if (!(employeeList.isEmpty())) {
                        System.out.print ("Enter Your ID: ");
                        int searchId = scan.nextInt ();
                        for (Employee p : employeeList){
                            if (searchId ==p.id){
                                p.addWork();
                                System.out.println (p);
                            }
                        }
                    } else {
                        System.out.println("Your list is empty");
                    }
                    break;
                case 4:
                    for (Employee p : employeeList)
                        System.out.println(p);
                    break;

                case 5:
                    System.out.print("Enter Employee Id for the details: ");
                    int searchId = scan.nextInt();
                    for (Employee p : employeeList){
                        if(searchId == p.id){
                            System.out.println(p);
                        }
                        else{
                            System.out.println("Unable to find the ID");
                        }
                    }
                    break;
            }

        }
    }
}