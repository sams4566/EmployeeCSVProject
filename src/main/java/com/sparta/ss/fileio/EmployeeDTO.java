package com.sparta.ss.fileio;

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

    public EmployeeDTO(String empID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String dateOfJoining, String salary) {
        this.empID = Integer.parseInt(String.valueOf(empID));
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = setDob(dob);
        this.dateOfJoining = setDateOfJoining(dateOfJoining);
        this.salary = Integer.parseInt(String.valueOf(salary));
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
