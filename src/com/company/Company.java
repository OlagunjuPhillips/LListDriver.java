package com.company;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> companyEmployees;

    public Company(ArrayList<Employee> companyEmployees){
        this.companyEmployees = companyEmployees;
    }

    public ArrayList<Employee>  getEmployeeList(){
        return companyEmployees;
    }

    public static ArrayList<Employee> populateCompany(int numberOfEmployees){
        return  Employee.generateRandomEmployees(numberOfEmployees);
    }
}
