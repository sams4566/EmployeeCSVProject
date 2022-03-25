package com.sparta.ss.database;

import java.sql.*;

public class EmployeesDAO {
    public static Connection connection;
    private Statement statement;

    public EmployeesDAO(Connection connection) {
        this.connection = connection;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printAllEmployees() {
        try {
            ResultSet resultSet = statement.executeQuery(SQLQueries.SELECT_ALL);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
                System.out.println(resultSet.getString(2));
                System.out.println(resultSet.getString(3));
                System.out.println(resultSet.getString(4));
                System.out.println(resultSet.getString(5));
                System.out.println(resultSet.getString(6));
                System.out.println(resultSet.getString(7));
                System.out.println(resultSet.getDate(8));
                System.out.println(resultSet.getDate(9));
                System.out.println(resultSet.getInt(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert(PreparedStatement preparedStatement, int empID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, Date dob, Date dateOfJoining, int salary) {
        try {
            preparedStatement.setInt(1, empID);
            preparedStatement.setString(2, namePrefix);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, middleInitial);
            preparedStatement.setString(5, lastName);
            preparedStatement.setString(6, gender);
            preparedStatement.setString(7, email);
            preparedStatement.setDate(8, dob);
            preparedStatement.setDate(9, dateOfJoining);
            preparedStatement.setInt(10, salary);
            preparedStatement.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
