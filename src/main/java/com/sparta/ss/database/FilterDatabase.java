package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;

import java.util.ArrayList;


public class FilterDatabase {
    public static ArrayList<EmployeeDTO> splitArrays(ArrayList<EmployeeDTO> employees, EmployeesDAO employeesDAO) {
        ArrayList<EmployeeDTO> employees1 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees2 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees3 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees4 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees5 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees6 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees7 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees8 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees9 = new ArrayList<EmployeeDTO>();
        ArrayList<EmployeeDTO> employees10 = new ArrayList<EmployeeDTO>();
        for (int i = 0; i < employees.size(); i++) {
            if (i < employees.size()/10) {
                employees1.add(employees.get(i));
            } else if (i < employees.size()* 2/10){
                employees2.add(employees.get(i));
            } else if (i < employees.size() * 3/10) {
                employees3.add(employees.get(i));
            } else if (i < employees.size() * 4/10) {
                employees4.add(employees.get(i));
            } else if (i < employees.size() * 5/10) {
                employees5.add(employees.get(i));
            } else if (i < employees.size() * 6/10) {
                employees6.add(employees.get(i));
            } else if (i < employees.size() * 7/10) {
                employees7.add(employees.get(i));
            } else if (i < employees.size() * 8/10) {
                employees8.add(employees.get(i));
            } else if (i < employees.size() * 9/10) {
                employees9.add(employees.get(i));
            } else {
                employees10.add(employees.get(i));
            }
        }
        filterToDatabase(
                employees1,
                employees2,
                employees3,
                employees4,
                employees5,
                employees6,
                employees7,
                employees8,
                employees9,
                employees10,
                employeesDAO
        );
        return employees;
    }

    public static EmployeesDAO filterToDatabase(
            ArrayList<EmployeeDTO> employees1,
            ArrayList<EmployeeDTO> employees2,
            ArrayList<EmployeeDTO> employees3,
            ArrayList<EmployeeDTO> employees4,
            ArrayList<EmployeeDTO> employees5,
            ArrayList<EmployeeDTO> employees6,
            ArrayList<EmployeeDTO> employees7,
            ArrayList<EmployeeDTO> employees8,
            ArrayList<EmployeeDTO> employees9,
            ArrayList<EmployeeDTO> employees10,
            EmployeesDAO employeesDAO
    ) {
        DatabaseThread thread1 = new DatabaseThread(employees1, employeesDAO);
        DatabaseThread thread2 = new DatabaseThread(employees2, employeesDAO);
        DatabaseThread thread3 = new DatabaseThread(employees3, employeesDAO);
        DatabaseThread thread4 = new DatabaseThread(employees4, employeesDAO);
        DatabaseThread thread5 = new DatabaseThread(employees5, employeesDAO);
        DatabaseThread thread6 = new DatabaseThread(employees6, employeesDAO);
        DatabaseThread thread7 = new DatabaseThread(employees7, employeesDAO);
        DatabaseThread thread8 = new DatabaseThread(employees8, employeesDAO);
        DatabaseThread thread9 = new DatabaseThread(employees9, employeesDAO);
        DatabaseThread thread10 = new DatabaseThread(employees10, employeesDAO);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        Thread t3 = new Thread(thread3);
        Thread t4 = new Thread(thread4);
        Thread t5 = new Thread(thread5);
        Thread t6 = new Thread(thread6);
        Thread t7 = new Thread(thread7);
        Thread t8 = new Thread(thread8);
        Thread t9 = new Thread(thread9);
        Thread t10 = new Thread(thread10);

        System.out.println("Starting threading...");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return employeesDAO;
    }
}
