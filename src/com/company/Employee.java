package com.company;
import java.time.LocalDate;
import java.util.*;

public class Employee {
    private String firstName;
    private LocalDate hireDate;
    private Double salary;

    public Employee(String firstName, LocalDate hireDate, Double salary){
        this.firstName = firstName;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String toString(){
        return "(Name of Employee: " + firstName+ ", Date of Hire: " + hireDate + ", Salary: " + salary+")";
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


    public static ArrayList<Employee> generateRandomEmployees(int numberOfEmployees){
        ArrayList<Employee> employeeList = new ArrayList<>();

        Scanner console = new Scanner(System.in);
        Random  rand = new Random();

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

            int yearGap = rand.nextInt(endYear - beginYear);
            int month = rand.nextInt(12) + 1;
            int day = rand.nextInt(31) + 1;
            if (month == 4 &&  day > 30 || month == 6 &&  day > 30 || month == 9 &&  day > 30 || month == 11 &&  day > 30){
                day -=  1;
            }else if (month == 2){
                if((yearGap + beginYear) % 4 == 0 && day > 29){
                    day -= 2;
                }else{
                    if(day > 28){
                        day -= 3;
                    }
                }
            }

            LocalDate hireDate = LocalDate.of(yearGap + beginYear,  month, day);

            Employee newEmployee = new Employee(name, hireDate, salary*1.0);

            employeeList.add(newEmployee);

        }
        return employeeList;
    }
}
