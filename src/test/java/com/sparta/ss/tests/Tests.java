package com.sparta.ss.tests;

import com.sparta.ss.fileio.CorruptionChecking;
import com.sparta.ss.fileio.EmployeeDTO;
import com.sparta.ss.fileio.FileIOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static com.sparta.ss.fileio.CorruptionChecking.*;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    @Test
    @DisplayName("Check no employees are lost when splitting into corrupted and valid arrays")
    void checkNoEmployeesAreLostWhenSplittingIntoCorruptedAndValidArrays() {
        try {
            FileReader fileReader = new FileReader("src/main/resources/EmployeeRecords.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            ArrayList<EmployeeDTO> numOfEmployees = new ArrayList<>();
            while (line != null) {
                String[] employeeData = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(employeeData);
                CorruptionChecking.checkEmployee(employeeDTO);
                numOfEmployees.add(employeeDTO);
                line = bufferedReader.readLine();
            }
            assertEquals(numOfEmployees.stream().count(), corruptedEmployees.stream().count() + validEmployees.stream().count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Test if employee is entered correctly into EmployeeDTO class")
    void testIfEmployeeIsEnteredCorrectlyIntoEmployeeDtoClass() {
        String[] employee = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        assertEquals(employeeDTO.getEmpID(), 133641);
    }

    @Test
    @DisplayName("Test that idDuplicate returns false")
    void testThatIdDuplicateReturnsFalse() {
        String[] employee = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        String[] employee2 = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(employee2);
        ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();
        validEmployees.add(employeeDTO);
        idDuplicate(employeeDTO2);
        assertFalse(idDuplicate(employeeDTO2));
    }
    
    @Test
    @DisplayName("TestName")
    void testName() {
        assertEquals(1,1);
    }
}
