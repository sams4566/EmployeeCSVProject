package com.sparta.ss.database;

public interface SQLQueries {
    public final String INSERT_INTO_DB = "INSERT INTO `employeecsv`.`employeecsv` (`empID`, `namePrefix`, `firstName`, `middleInitial`, `lastName`, `gender`, `email`, `dob`, `dateOfJoining`, `salary`) VALUES (?,?,?,?,?,?,?,?,?,?)";
    String SELECT_ALL = "SELECT * FROM employeecsv.employeecsv";
}
