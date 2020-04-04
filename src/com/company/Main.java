package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to Company.");
        System.out.println();

        // TODO odd, the assignment sheet says to add 11 random employees but you require user input
        System.out.print("How many employees do you want in the company: ");
        int numberOfEmployees = console.nextInt();

        Company myCompany = new Company(Company.populateCompany(numberOfEmployees));
        ArrayList<Employee> companyEmployees = myCompany.getEmployeeList();
        System.out.println();

        System.out.print("What salary benchmark do you want to check: ");
        int amount = console.nextInt();

        System.out.println(checkIfAnyEmployeeMakesMoreThan(amount, companyEmployees, 0));
        System.out.println();

        System.out.println("Calculating number of employees with same name as first employee on the list...");
        String firstNameOnList = myCompany.getEmployeeList().get(0).getName();
        System.out.println(countNamesSameAsFirstNameOnList(firstNameOnList, companyEmployees,0));
        System.out.println("Done.");
        System.out.println();

        System.out.println("Calculating  minimum Salary of Employees...");
        System.out.println(calculateMinimumSalary(companyEmployees, 0));
        System.out.println("Done.");
        System.out.println();


        System.out.print("How many years back do you want to check your number of hires: ");
        int years = console.nextInt();
        System.out.println("Getting indexes of Employees hired within the last specified number of years... ");
        System.out.println(determineIndexesOfEmployeesHiredWithinPastYears(companyEmployees, years, 0));
        System.out.println("Done.");
        System.out.println();

        System.out.print("By how much do you want to increase Employees salary: ");
        double increase = console.nextDouble();
        System.out.println("Increasing all Employees Salary...");
        increaseAllEmployeeSalary(companyEmployees, increase, 0);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Thank you for using Company");



    }

    static boolean  checkIfAnyEmployeeMakesMoreThan(int amount, ArrayList<Employee> employeeList, int i){
        Employee employee = employeeList.get(i);
        if(i == employeeList.size() - 1){
            return false;
        }else{
            if(employee.getSalary() > amount){
                return true;
            }else{
                i++;
                return checkIfAnyEmployeeMakesMoreThan(amount, employeeList, i);
            }
        }
    }

    static int countNamesSameAsFirstNameOnList(String firstNameOnList, ArrayList<Employee>  employeeList, int i){
        int count = 0;
        Employee employee = employeeList.get(i);
        if(i == employeeList.size() - 1){
            return count;
        }else{
            if(employee.getName().equals(firstNameOnList)){
                count++;
            }
            i++;
            return  count += countNamesSameAsFirstNameOnList(firstNameOnList, employeeList, i);
        }
    }

    static double calculateMinimumSalary(ArrayList<Employee> employeeList, int i){
        Employee employee =  employeeList.get(i);
        double minimumSalary = employee.getSalary();
        if(i ==  employeeList.size() - 1){
            return minimumSalary;
        }else{
            if(employee.getSalary() < minimumSalary){
                minimumSalary = employee.getSalary();
            }
            i++;
            return calculateMinimumSalary(employeeList, i);
        }

    }

    static ArrayList<Integer> determineIndexesOfEmployeesHiredWithinPastYears(ArrayList<Employee> employeeList, int year, int i){
        ArrayList<Integer> indexes = new ArrayList<>();
        Employee employee = employeeList.get(i);
        if(i == employeeList.size() - 1){
            return indexes;
        }else{
            if(LocalDate.now().getYear() - employee.getHireDate().getYear() <= year){
                indexes.add(i);
            }
            i++;
            return(determineIndexesOfEmployeesHiredWithinPastYears(employeeList, year, i));
        }
    }

    static void increaseAllEmployeeSalary(ArrayList<Employee> employeeList,  double increase, int i){
        if(i < employeeList.size()) {
            Employee employee = employeeList.get(i);
            employee.setSalary(employee.getSalary() + increase);
            i++;
            increaseAllEmployeeSalary(employeeList, increase, i);
        }
    }
}
