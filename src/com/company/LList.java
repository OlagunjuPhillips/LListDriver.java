package com.company;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class LList {
    private Employee employee;
    private LList next;

    public LList(Employee employee){

        // TODO this is one of the common Java gotchas
        //  Don't assign reference parameters without using new
        this.employee = employee;
        this.next = null;
    }

    public String toString(){
        return employee+" ----> "+next;
    }

    // TODO as practice, re-write this as a recursive method
    public LList addToHead(Employee  employee){
        LList first = new LList(employee);
        first.next = this;
        return first;
    }

    // TODO as practice, re-write this as a recursive method
    public Employee get(int index){
        LList current = this;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.employee;
    }

    // TODO as practice, re-write this as a recursive method
    public int size(){
        LList  current = this;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }


    // TODO good job, you used static properly
    // TODO see my many comments in Employees.generateRandomEmployees() to see how to improve this code
    public static LList populateLinkedListWithEmployees(int numberOfEmployees){

        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        String[] names = {"John", "Mike", "Ronald", "Galosh", "Rockford", "Daniel", "Tom", "Phil", "Rock", "James"};
        System.out.println("What year did you start hiring: ");
        int beginYear = console.nextInt();
        System.out.println("What year did you stop  hiring: ");
        int endYear = console.nextInt();
        System.out.print("What is the maximum amount any employee can earn per annum: ");
        int highestAmount = console.nextInt();

        int nameIndex = rand.nextInt(names.length);
        String name = names[nameIndex];
        int salary = rand.nextInt(highestAmount);

        int yearGap = rand.nextInt(endYear - beginYear);
        int month = rand.nextInt(12) + 1;
        int day = rand.nextInt(31) + 1;
        if (month == 4 &&  day > 30 || month == 6 &&  day > 30 || month == 9 &&  day > 30 || month == 11 &&  day > 30){
            day -=  1;
        }else if (month == 2 && day > 28){
            day -= 2;
        }

        LocalDate hireDate = LocalDate.of(yearGap + beginYear,  month, day);

        Employee newEmployee = new Employee(name, hireDate, salary*1.0);

        LList employeeLinkedList = new LList(newEmployee);

        for(int i = 0; i < numberOfEmployees - 1; i++){

            nameIndex = rand.nextInt(names.length);
            name = names[nameIndex];
            salary = rand.nextInt(highestAmount);

            // TODO YUCK!!!  Every time you find yourself repeating code (like the copy-and-paste) you did from
            // your above code, you should convert that code into a function/method.
            // Programmers call this DRY (Don't Repeat Yourself).
            yearGap = rand.nextInt(endYear - beginYear);
            month = rand.nextInt(12) + 1;
            day = rand.nextInt(31) + 1;
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

            hireDate = LocalDate.of(yearGap + beginYear,  month, day);

            newEmployee = new Employee(name, hireDate, salary*1.0);

            employeeLinkedList = employeeLinkedList.addToHead(newEmployee);
        }
        return employeeLinkedList;
    }
}
