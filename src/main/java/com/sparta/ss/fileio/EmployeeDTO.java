package com.sparta.ss.fileio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeDTO {
    private int empID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dob;
    private LocalDate dateOfJoining;
    private int salary;

    public LocalDate setDob(String dob) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(dob, formatter);
        return date;
    }

    public LocalDate setDateOfJoining(String dateOfJoining) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate date = LocalDate.parse(dateOfJoining, formatter);
        return date;
    }

    public EmployeeDTO(String[] employeeData) {
        this.empID = Integer.parseInt(String.valueOf(employeeData[0]));
        this.namePrefix = employeeData[1];
        this.firstName = employeeData[2];
        this.middleInitial = employeeData[3];
        this.lastName = employeeData[4];
        this.gender = employeeData[5];
        this.email = employeeData[6];
        this.dob = setDob(employeeData[7]);
        this.dateOfJoining = setDateOfJoining(employeeData[8]);
        this.salary = Integer.parseInt(String.valueOf(employeeData[9]));
    }

    public int getEmpID() {
        return empID;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public int getSalary() {
        return salary;
    }

    public Date getDobSql() {
        Date date = Date.valueOf(dob);
        return date;
    }

    public Date getDateOfJoiningSql() {
        Date date = Date.valueOf(dateOfJoining);
        return date;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empID='" + empID + '\'' +
                ", namePrefix='" + namePrefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }
}
