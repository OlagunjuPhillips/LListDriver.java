package com.company;

import java.time.LocalDate;
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

    public int countNamesSameAsFirstNameOnList(String firstNameOnList, ArrayList<Employee>  employeeList, int index,int count){
        Employee employee = employeeList.get(index);
        if(index == employeeList.size() - 1){
            return count;
        }else{
            if(employee.getName().equals(firstNameOnList)){
                count++;
            }
            index++;
            return  countNamesSameAsFirstNameOnList(firstNameOnList, employeeList, index, count);
        }
    }

    public double calculateMinimumSalary(ArrayList<Employee> employeeList, int i){
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

    public ArrayList<Integer> determineIndexesOfEmployeesHiredWithinPastYears(ArrayList<Employee> employeeList, int year,
                                                                              int index, ArrayList<Integer> indexes){
        Employee employee = employeeList.get(index);
        if(index == employeeList.size() - 1){
            return indexes;
        }else{
            if(LocalDate.now().getYear() - employee.getHireDate().getYear() <= year){
                indexes.add(index);
            }
            index++;
            return(determineIndexesOfEmployeesHiredWithinPastYears(employeeList, year, index, indexes));
        }
    }

    public boolean  checkIfAnyEmployeeMakesMoreThan(int amount, ArrayList<Employee> employeeList, int index){
        Employee employee = employeeList.get(index);
        if(index == employeeList.size() - 1){
            return false;
        }else{
            if(employee.getSalary() > amount){
                return true;
            }else{
                index++;
                return checkIfAnyEmployeeMakesMoreThan(amount, employeeList, index);
            }
        }
    }

    public void increaseAllEmployeeSalary(ArrayList<Employee> employeeList,  double increase, int index){
        if(index < employeeList.size()) {
            Employee employee = employeeList.get(index);
            employee.setSalary(employee.getSalary() + increase);
            index++;
            increaseAllEmployeeSalary(employeeList, increase, index);
        }
    }
}
