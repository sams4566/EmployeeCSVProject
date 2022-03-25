package com.sparta.ss.tests;

import com.mysql.cj.conf.StringPropertyDefinition;
import com.sparta.ss.fileio.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static com.sparta.ss.fileio.CorruptionChecking.checkEmployee;
import static com.sparta.ss.fileio.CorruptionChecking.idDuplicate;

public class Test2 {
    @Test
    @DisplayName("Test checkEmployee")
//    void testCheckEmployee() {
//        EmployeeDTO employee1 = new EmployeeDTO("1313" "Mr")
//        Assertions.assertTrue(checkEmployee(), );
    }

    @Test
    @DisplayName("Test idDuplicate")
    void testIDDuplicate() {
        String[] employee = new String[]{"123","Mr", "Mujtaba", "M", "Moosavi", "mm@hotmail.com", "12/12/2012", "1/12/2020", "23128"};
        EmployeeDTO employeeDTO  = new EmployeeDTO(employee);
        String[] employee2 = new String[]{"123", "Mr", "Sam", "M", "Moosavi", "sam@hotmail.com", "12/1/2012", "4/12/2020", "23128"};
        EmployeeDTO employeeDTO2 = new EmployeeDTO(employee2);
        ArrayList<EmployeeDTO> validEmployees = new ArrayList<EmployeeDTO>();
        validEmployees = {employeeDTO,employeeDTO2};

        Assertions.assertTrue(idDuplicate(employee2));
    }


//    String[] employee = new String[]{"123","Mr", "Mujtaba", "M", "Moosavi", "mm@hotmail.com", "12/12/2012", "1/12/2020", "23128"};
//    EmployeeDTO employeeDTO  = new EmployeeDTO(employee);
//    Strin
//    ArrayList<EmployeeDTO> validEmployees = new ArrayList<EmployeeDTO>();
//    validEmployees = {123, "Mr", "Mujtaba", "M", "Moosavi", "mm@hotmail.com", 12/12/2012, 01/12/2020, 23128};
//    EmployeeDTO employee2 = new EmployeeDTO(123, "Mr", "Sam", "M", "Moosavi"
//            "sam@hotmail.com", 12/2012, 4/12/2020, 23128 );
//        Assertions.assertTrue(idDuplicate(employee2));
//
//    private int empID;
//    private String namePrefix;
//    private String firstName;
//    private String middleInitial;
//    private String lastName;
//    private String gender;
//    private String email;
//    private LocalDate dob;
//    private LocalDate dateOfJoining;
//    private int salary;
}
