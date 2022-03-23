package com.sparta.ss.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionManager.getConnection();
        EmployeesDAO employeesDAO = new EmployeesDAO(connection);
        employeesDAO.insert(2, "mr", "neil", "neil", "neil", "neil", "neil", 1,2,3 );
        employeesDAO.printAllEmployees();
        ConnectionManager.closeConnection();
    }
}
