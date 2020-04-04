package com.company;
import java.time.LocalDate;
import java.util.*;

public class Employee {
    String firstName;
    LocalDate hireDate;
    Double salary;

    public Employee(String firstName, LocalDate hireDate, Double salary){
        this.firstName = firstName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String toString(){
        return "Name of Employee: " +firstName+"\t Date of Hire: " + hireDate + "\t Salary: " + salary;
    }

    public String getName(){
        return  firstName;
    }

    public LocalDate getHireDate(){
        return hireDate;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    // TODO maybe, this method could be in the Company class and return a Companuy object
    //  rather than being in the Employee class and returning an ArrayList of Employee objects
    public static ArrayList<Employee> generateRandomEmployees(int numberOfEmployees){
        ArrayList<Employee> employeeList = new ArrayList<>();

        Scanner console = new Scanner(System.in);
        Random  rand = new Random();

        // TODO this should be a constant so static and final
        String[] names = {"John", "Mike", "Ronald", "Galosh", "Rockford", "Daniel", "Tom", "Phil", "Rock", "James"};

        System.out.println("What year did you start hiring: ");
        int beginYear = console.nextInt();
        System.out.println("What year did you stop  hiring: ");
        int endYear = console.nextInt();
        System.out.print("What is the maximum amount any employee can earn per annum: ");
        int highestAmount = console.nextInt();

        for(int i = 0; i < numberOfEmployees; i++){
            int nameIndex = rand.nextInt(names.length);
            String name = names[nameIndex];
            int salary = rand.nextInt(highestAmount);

            // TODO this should be a generateRandomDate() method.
            // TODO I suspect java.time.LocalTime  has a much easier way to add a random number to a date
            int yearGap = rand.nextInt(endYear - beginYear);
            int month = rand.nextInt(12) + 1;
            int day = rand.nextInt(31) + 1;
            if (month == 4 &&  day > 30 || month == 6 &&  day > 30 || month == 9 &&  day > 30 || month == 11 &&  day > 30){
                day -=  1;
            }else if (month == 2 && day > 28){
                day -= 2;
            }

            LocalDate hireDate = LocalDate.of(yearGap + beginYear,  month, day);

            // TODO combine these two statements into
            // TODO it is more descriptive to cast than to multiply by 1.0
            // employeeList.add( new Employee(name, hireDate, (double) salary );
            Employee newEmployee = new Employee(name, hireDate, salary*1.0);
            employeeList.add(newEmployee);

        }
        return employeeList;
    }
}
