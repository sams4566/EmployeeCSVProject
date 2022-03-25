package com.sparta.ss.tests;

import com.sparta.ss.fileio.EmployeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static com.sparta.ss.fileio.CorruptionChecking.idDuplicate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test2 {


    @Test
    @DisplayName("Test ")
    void methodName() {
        Assertions.assertEquals(1,1);
    }
    
    @Test
    @DisplayName("Test idDuplicate returns true if no duplicate ID")
    void testIDDuplicateReturnsTrueForNoDuplicates() {
        String[] employee = new String[]{"123456", "Mr.", "Mujtaba", "M", "Moosavi", "M", "mm@hotmail.com", "12/12/2012", "1/12/2020", "23126"};
        String[] employee2 = new String[]{"123457", "Mr.", "Sam", "M", "Moosavi", "M", "sam@hotmail.com", "12/1/2012", "4/12/2020", "23128"};
        String[] employee3 = new String[]{"123458", "Mr.", "Nugat", "M", "Moosavi", "M", "nugat@hotmail.com", "12/1/2008", "4/12/2020", "23132"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(employee2);
        EmployeeDTO employeeDTO3 = new EmployeeDTO(employee3);
        ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();
        validEmployees.add(employeeDTO);
        validEmployees.add(employeeDTO2);
        idDuplicate(employeeDTO3);
        Assertions.assertFalse(idDuplicate(employeeDTO3));
    }
}


