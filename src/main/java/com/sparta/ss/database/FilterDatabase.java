package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;

import java.util.ArrayList;

public class FilterDatabase {
    public static ArrayList<EmployeeDTO> splitArrays(ArrayList<EmployeeDTO> employees, EmployeesDAO employeesDAO) {
        ArrayList<EmployeeDTO> employees1 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees2 = new ArrayList<EmployeeDTO>();
        for (int i = 0; i < employees.size(); i++) {
            if (i < employees.size()/2) {
                employees1.add(employees.get(i));
            } else {
                employees2.add(employees.get(i));
            }
        }
        filterToDatabase(employees1, employees2, employeesDAO);
        return employees;
    }

    public static int filterToDatabase(ArrayList<EmployeeDTO> employees1, ArrayList<EmployeeDTO> employees2, EmployeesDAO employeesDAO) {
        DatabaseThread thread1 = new DatabaseThread(employees1, employeesDAO);
        DatabaseThread thread2 = new DatabaseThread(employees2, employeesDAO);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);

        System.out.println("Starting threading");

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
