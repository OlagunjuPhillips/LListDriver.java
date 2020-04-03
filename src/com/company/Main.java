package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to Company.");
        System.out.println();

        System.out.print("How many employees do you want in the company: ");
        int numberOfEmployees = console.nextInt();

        Company myCompany = new Company(Company.populateCompany(numberOfEmployees));
        ArrayList<Employee> companyEmployees = myCompany.getEmployeeList();
        System.out.println();

        System.out.print("What salary benchmark do you want to check: ");
        int amount = console.nextInt();

        System.out.println("Checking if any employee makes more than specified amount per annum...");
        System.out.println(myCompany.checkIfAnyEmployeeMakesMoreThan(amount, companyEmployees, 0));
        System.out.println("Done.");
        System.out.println();

        System.out.println("Calculating number of employees with same name as first employee on the list...");
        String firstNameOnList = myCompany.getEmployeeList().get(0).getName();
        System.out.println(myCompany.countNamesSameAsFirstNameOnList(firstNameOnList, companyEmployees,0,
                0));

        System.out.println("Done.");
        System.out.println();

        System.out.println("Calculating  minimum Salary of Employees...");
        System.out.println(myCompany.calculateMinimumSalary(companyEmployees, 0));
        System.out.println("Done.");
        System.out.println();


        System.out.print("How many years back do you want to check your number of hires: ");
        int years = console.nextInt();
        System.out.println("Getting indexes of Employees hired within the last specified number of years... ");
        ArrayList<Integer> indexList = new ArrayList<>();
        System.out.println(myCompany.determineIndexesOfEmployeesHiredWithinPastYears(companyEmployees, years,
                0, indexList));

        System.out.println("Done.");
        System.out.println();

        System.out.print("By how much do you want to increase Employees salary: ");
        double increase = console.nextDouble();
        System.out.println("Increasing all Employees Salary...");
        myCompany.increaseAllEmployeeSalary(companyEmployees, increase, 0);
        System.out.println("Done.");
        System.out.println();

        System.out.println("Thank you for using Company");

    }










}
