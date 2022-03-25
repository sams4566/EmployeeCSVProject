package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;
import com.sparta.ss.fileio.FileIOUtils;

import java.sql.Connection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        EmployeesDAO employeesDAO = new EmployeesDAO(connection);
        ArrayList<EmployeeDTO> employees = FileIOUtils.readFile("src/main/resources/EmployeeRecordsLarge.csv");
        long timeStart = System.nanoTime();
        FilterDatabase.splitArrays(employees, employeesDAO);
        long timeEnd = System.nanoTime();
        System.out.println("Database filter time: " + (timeEnd - timeStart)/1000000000 + " seconds");
        System.out.println("Database finished loading");
        ConnectionManager.closeConnection();
    }
}

