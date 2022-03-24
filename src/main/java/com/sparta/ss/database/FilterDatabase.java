package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;

import java.util.ArrayList;


public class FilterDatabase {
    public static ArrayList<EmployeeDTO> splitArrays(ArrayList<EmployeeDTO> employees, EmployeesDAO employeesDAO) {
        ArrayList<EmployeeDTO> employees1 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees2 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees3 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees4 = new ArrayList<EmployeeDTO>();
        for (int i = 0; i < employees.size(); i++) {
            if (i < employees.size()/4) {
                employees1.add(employees.get(i));
            } else if (i < employees.size()/2){
                employees2.add(employees.get(i));
            } else if (i < employees.size() * 3/4) {
                employees3.add(employees.get(i));
            } else {
                employees4.add(employees.get(i));
            }
        }
        filterToDatabase(employees1, employees2, employees3, employees4, employeesDAO);
        return employees;
    }

    public static int filterToDatabase(ArrayList<EmployeeDTO> employees1, ArrayList<EmployeeDTO> employees2, ArrayList<EmployeeDTO> employees3, ArrayList<EmployeeDTO> employees4, EmployeesDAO employeesDAO) {
        DatabaseThread thread1 = new DatabaseThread(employees1, employeesDAO);
        DatabaseThread thread2 = new DatabaseThread(employees2, employeesDAO);
        DatabaseThread thread3 = new DatabaseThread(employees3, employeesDAO);
        DatabaseThread thread4 = new DatabaseThread(employees4, employeesDAO);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread3);
        Thread t4 = new Thread(thread4);

        System.out.println("Starting threading");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
