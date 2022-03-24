package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;

import java.util.ArrayList;

public class DatabaseThread implements Runnable {
    private ArrayList<EmployeeDTO> list;
    private EmployeesDAO employeesDAO;

    public DatabaseThread(ArrayList<EmployeeDTO> theList, EmployeesDAO employeesDAO) {
        this.list = theList;
        this.employeesDAO = employeesDAO;
    }

    public void addToDatabase() {
        for (EmployeeDTO employee : list) {
            synchronized (list) {
                employeesDAO.insert(
                        employee.getEmpID(),
                        employee.getNamePrefix(),
                        employee.getFirstName(),
                        employee.getMiddleInitial(),
                        employee.getLastName(),
                        employee.getGender(),
                        employee.getEmail(),
                        employee.getDobSql(),
                        employee.getDobSql(),
                        employee.getSalary()
                );
                System.out.println(employee.getEmpID());
            }
        }
    }

    @Override
    public void run() {
        addToDatabase();
    }
}
