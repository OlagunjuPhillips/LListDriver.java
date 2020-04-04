package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Company {

    // TODO Phillips, in this code your methods don't really care about Company, instead you only care about
    //  the companyEmployees.  So why is that bad?  Because a goal in writing classes is "information hiding".
    //  We don't want programmers to know what's going on in our classes, expect through our parameter list
    //  and our return value.  Because nearly all your methods are returning our list of employees, callers will
    //  ignore your Company class and just work with your list of employees.  This is bad because maybe in the future
    //  our team decides to change the companyEmployees to be of type Queue.  Oh no, just by doing that nearly all
    //  of your code will break.
    private ArrayList<Employee> companyEmployees;

    public Company(ArrayList<Employee> companyEmployees){
        this.companyEmployees = companyEmployees;
    }

    public ArrayList<Employee>  getEmployeeList(){
        return companyEmployees;
    }

    // TODO shouldn't this return a Company object
    public static ArrayList<Employee> populateCompany(int numberOfEmployees){
        return  Employee.generateRandomEmployees(numberOfEmployees);
    }

    public int countNamesSameAsFirstNameOnList(String firstNameOnList, ArrayList<Employee>  employeeList, int index,int count){
        Employee employee = employeeList.get(index);

        // TODO odd, why isn't this index >= employeeList.size()
        if(index == employeeList.size() - 1){
            return count;
        } //else{  // TODO you don't need this else clause, you need the code but not the word else
            if(employee.getName().equals(firstNameOnList)){
                count++;
            }
            index++;
            return  countNamesSameAsFirstNameOnList(firstNameOnList, employeeList, index, count);
        // }
    }

    public double calculateMinimumSalary(ArrayList<Employee> employeeList, int i){
        Employee employee =  employeeList.get(i);

        // TODO oh no, because this is recursive, every recursive step this variable will be re-set
        //  need to pass it as a parameter
        double minimumSalary = employee.getSalary();

        // TODO odd, why isn't this index >= employeeList.size()
        if(i ==  employeeList.size() - 1){
            return minimumSalary;
        }else{  // TODO you don't need this else clause, you need the code but not the word else
            if(employee.getSalary() < minimumSalary){  // TODO do you see why this is never true
                minimumSalary = employee.getSalary();
            }
            i++;
            return calculateMinimumSalary(employeeList, i);
        }

    }

    // TODO good job, you let the caller send you the # of years
    // TODO year is oddly worded because it's not a year like 2020
    public ArrayList<Integer> determineIndexesOfEmployeesHiredWithinPastYears(ArrayList<Employee> employeeList, int year,
                                                                              int index, ArrayList<Integer> indexes){
        Employee employee = employeeList.get(index);

        // TODO odd, why isn't this index >= employeeList.size()
        if(index == employeeList.size() - 1){
            return indexes;
        }else{  // TODO you don't need this else clause, you need the code but not the word else

            // TODO YUCK, I bet java.time.LocalDate knows how to compare dates
            if(LocalDate.now().getYear() - employee.getHireDate().getYear() <= year){
                indexes.add(index);
            }
            index++;
            return(determineIndexesOfEmployeesHiredWithinPastYears(employeeList, year, index, indexes));
        }
    }

    public boolean  checkIfAnyEmployeeMakesMoreThan(int amount, ArrayList<Employee> employeeList, int index){
        Employee employee = employeeList.get(index);

        // TODO odd, why isn't this index >= employeeList.size()
        if(index == employeeList.size() - 1){
            return false;
        }else{  // TODO you don't need this else clause, you need the code but not the word else
            if(employee.getSalary() > amount){
                return true;
            }else{  // TODO you don't need this else clause, you need the code but not the word else
                index++;
                return checkIfAnyEmployeeMakesMoreThan(amount, employeeList, index);
            }
        }
    }

    // TODO so how could you write this in a way that "enforces information hiding"?
    // Your method signature should be
    // public void increaseAllEmployeeSalary( double increase, int index) { ... }
    // Notice there is no need to pass the employeeList since it is an instance variable.
    public void increaseAllEmployeeSalary(ArrayList<Employee> employeeList,  double increase, int index){
        if(index < employeeList.size()) {
            Employee employee = employeeList.get(index);
            employee.setSalary(employee.getSalary() + increase);
            index++;
            increaseAllEmployeeSalary(employeeList, increase, index);
        }
    }
}
