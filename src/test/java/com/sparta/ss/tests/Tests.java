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
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

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
    void testIfEmployeeIdIsEnteredCorrectlyIntoEmployeeDtoClass() {
        String[] employee = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        assertEquals(employeeDTO.getEmpID(), 133641);
    }

    @Test
    @DisplayName("Test if employee DOB is entered correctly into EmployeeDTO class")
    void testIfEmployeeDobIsEnteredCorrectlyIntoEmployeeDtoClass() {
        String[] employee = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        String actual = "4/20/1995";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate dateInitial = LocalDate.parse(actual, formatter);
        Date date = Date.valueOf(dateInitial);
        assertEquals(employeeDTO.getDobSql(), date);
        assertEquals(String.valueOf(employeeDTO.getDobSql().getClass()), "class java.sql.Date");
    }

    @Test
    @DisplayName("Test that id Duplicate returns true if duplicate ID")
    void testThatIdDuplicateReturnsTrueIfDuplicateId() {
        String[] employee = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        String[] employee2 = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(employee2);
        ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();
        validEmployees.add(employeeDTO);
        idDuplicate(employeeDTO2, validEmployees);
        assertTrue(idDuplicate(employeeDTO2, validEmployees));
    }

    @Test
    @DisplayName("Test idDuplicate returns false if no duplicate ID")
    void testIDDuplicateReturnsFalseForNoDuplicateId() {
        String[] employee = new String[]{"123456", "Mr.", "Mujtaba", "M", "Moosavi", "M", "mm@hotmail.com", "12/12/2012", "1/12/2020", "23126"};
        String[] employee2 = new String[]{"123457", "Mr.", "Sam", "M", "Moosavi", "M", "sam@hotmail.com", "12/1/2012", "4/12/2020", "23128"};
        String[] employee3 = new String[]{"123458", "Mr.", "Nugat", "M", "Moosavi", "M", "nugat@hotmail.com", "12/1/2008", "4/12/2020", "23132"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        EmployeeDTO employeeDTO2 = new EmployeeDTO(employee2);
        EmployeeDTO employeeDTO3 = new EmployeeDTO(employee3);
        ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();
        validEmployees.add(employeeDTO);
        validEmployees.add(employeeDTO2);
        Assertions.assertFalse(idDuplicate(employeeDTO3, validEmployees));
    }

    @Test
    @DisplayName("Test that genderCorrect returns false if incorrect")
    void testThatGenderCorrectReturnsFalseIfIncorrect() {
        String[] employee = new String[] {"133641", "Mr.", "Chas", "F", "Hurdle", "M", "chas.hurdle@gmail.com", "4/20/1995", "5/28/2016", "45102"};
        EmployeeDTO employeeDTO = new EmployeeDTO(employee);
        genderCorrect(employeeDTO);
        assertFalse(genderCorrect(employeeDTO));
    }
}
