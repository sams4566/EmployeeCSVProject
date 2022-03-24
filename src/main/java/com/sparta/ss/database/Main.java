package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;
import com.sparta.ss.fileio.FileIOUtils;

import java.sql.Connection;
import java.util.ArrayList;

import static com.sparta.ss.database.FilterDatabase.splitArrays;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        EmployeesDAO employeesDAO = new EmployeesDAO(connection);
        ArrayList<EmployeeDTO> employees = FileIOUtils.readFile("src/main/resources/EmployeeRecords.csv");
        FilterDatabase.splitArrays(employees, employeesDAO);
        System.out.println("Database finished loading");
        ConnectionManager.closeConnection();
    }
}

