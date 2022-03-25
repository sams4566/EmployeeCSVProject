package com.sparta.ss.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static com.sparta.ss.fileio.CorruptionChecking.corruptedEmployees;
import static com.sparta.ss.fileio.CorruptionChecking.validEmployees;

public class FileIOUtils {
    public static ArrayList readFile(String fileName) {
        try {
            System.out.println("Checking for corruptions...");
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] employeeData = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(employeeData);
//                System.out.println(employeeDTO.getGender());
                CorruptionChecking.checkEmployee(employeeDTO);
                line = bufferedReader.readLine();
            }
            System.out.println("Number of Corrupted Employees: " + corruptedEmployees.stream().count());
            System.out.println("Number of Valid Employees: " + validEmployees.stream().count());
            return validEmployees;
        } catch (IOException e) {
            e.printStackTrace();
            ArrayList<EmployeeDTO> employees = new ArrayList<>();
            return employees;
        }
    }
}
