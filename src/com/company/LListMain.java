package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LListMain {
    public static void main(String[] args){
        Scanner console = new Scanner(System.in);

        System.out.println("Welcome to Company Linked List.");
        System.out.println();

        System.out.print("How many employees are in the company: ");
        int numberOfEmployees = console.nextInt();
        System.out.println();

        System.out.println("Populating and printing Company Linked List...");
        LList  employeeList = LList.populateLinkedListWithEmployees(numberOfEmployees);
        System.out.println(employeeList);
        System.out.println("Done");
        System.out.println();

        System.out.println("Calculating number of employees who make more than specified amount per annum...");
        System.out.print("What amount is the benchmark for comparison: ");
        int amount = console.nextInt();
        int number = numberOfEmployeesThatMakeAbove(employeeList, amount);
        System.out.println(number);
        System.out.println("Done");
        System.out.println();

        System.out.println("Counting number of names that are the same as the first name on the list...");
        int numOfNamesAsFirstOnList = countNumberOfNamesAsFirst(employeeList.get(0).getName(), employeeList);
        System.out.println(numOfNamesAsFirstOnList);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Calculating minimum Salary of the employees...");
        double minimumSalary = minimumSalary(employeeList);
        System.out.println(minimumSalary);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Getting index of people employed within the last X years");
        System.out.print("What is your value of X: ");
        int years = console.nextInt();
        ArrayList<Integer> indexes = getIndexEmployedXYearsAgo(years, employeeList);
        System.out.println(indexes);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Increasing employee salary...");
        System.out.print("How much do you want to add to  employee salary: ");
        double increase = console.nextDouble();
        increaseEmployeesSalary(increase, employeeList);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Thank for using Company Linked List.");






    }

    static int numberOfEmployeesThatMakeAbove(LList employeeList, int amount){
        int count = 0;
        for(int i = 0; i < employeeList.size() - 1; i++){
            Employee employee = employeeList.get(i);
            if(employee.getSalary() > amount){
                count ++;
            }
        }
        return count;
    }

    static int countNumberOfNamesAsFirst(String name, LList employeeList){
        int count = 0;
        for(int i = 0; i < employeeList.size() - 1; i++){
            if(employeeList.get(i).getName().equals(name)){
                count++;
            }
        }
        return count;
    }

    static double minimumSalary(LList employeeList){
        double minimumSalary = employeeList.get(0).getSalary();
        for(int i = 0; i < employeeList.size() - 1; i++){
            if(employeeList.get(i).getSalary() < minimumSalary){
                minimumSalary = employeeList.get(i).getSalary();
            }
        }
        return minimumSalary;
    }

    static ArrayList<Integer> getIndexEmployedXYearsAgo(int years, LList employeeList){
        ArrayList<Integer> indexes = new ArrayList<>();
        for(int i = 0; i < employeeList.size() - 1; i++){
            if(LocalDate.now().getYear() - employeeList.get(i).getHireDate().getYear() <= years){
                indexes.add(i);
            }
        }
        return indexes;
    }

    static void increaseEmployeesSalary(double increase, LList employeeList){
        for(int i = 0; i < employeeList.size() - 1; i++){
            employeeList.get(i).setSalary(employeeList.get(i).getSalary() + increase);
        }
    }

}
