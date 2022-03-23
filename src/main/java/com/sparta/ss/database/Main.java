package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;
import com.sparta.ss.fileio.FileIOUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        EmployeesDAO employeesDAO = new EmployeesDAO(connection);
        ArrayList<EmployeeDTO> employees = FileIOUtils.readFile("src/main/resources/EmployeeRecords.csv");
        for (EmployeeDTO employee : employees) {
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
        employeesDAO.printAllEmployees();
        ConnectionManager.closeConnection();
    }
}
