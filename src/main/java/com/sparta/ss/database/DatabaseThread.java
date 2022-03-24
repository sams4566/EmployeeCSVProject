package com.sparta.ss.database;

import com.sparta.ss.fileio.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseThread implements Runnable {
    private ArrayList<EmployeeDTO> list;
    private EmployeesDAO employeesDAO;

    public DatabaseThread(ArrayList<EmployeeDTO> theList, EmployeesDAO employeesDAO) {
        this.list = theList;
        this.employeesDAO = employeesDAO;
    }

    public void addToDatabase() {
        Connection connection = ConnectionManager.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SQLQueries.INSERT_INTO_DB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (EmployeeDTO employee : list) {
            synchronized (list) {
                employeesDAO.insert(
                        preparedStatement,
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
        try {
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        addToDatabase();
    }
}
