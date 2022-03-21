package com.sparta.ss.fileio;

public class EmployeeDTO {
    private String empID;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private String dob; //private LocalDate dob;
    private String dateOfJoining;
    private String salary;

    public EmployeeDTO(String empID, String namePrefix, String firstName, String middleInitial, String lastName, String gender, String email, String dob, String dateOfJoining, String salary) {
        this.empID = empID;
        this.namePrefix = namePrefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
        this.dateOfJoining = dateOfJoining;
        this.salary = salary;
    }

    public String getEmpID() {
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

    public String getDob() {
        return dob;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public String getSalary() {
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
