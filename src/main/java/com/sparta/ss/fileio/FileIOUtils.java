package com.sparta.ss.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static com.sparta.ss.fileio.CorruptionChecking.duplicates;
import static com.sparta.ss.fileio.CorruptionChecking.validEmployees;

public class FileIOUtils {
    public static ArrayList readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] employeeData = line.split(",");
                EmployeeDTO employeeDTO = new EmployeeDTO(
                        employeeData[0],
                        employeeData[1],
                        employeeData[2],
                        employeeData[3],
                        employeeData[4],
                        employeeData[5],
                        employeeData[6],
                        employeeData[7],
                        employeeData[8],
                        employeeData[9]
                );
//                String[] employeeData = line.split(",");
//                EmployeeDTO employeeDTO = new EmployeeDTO(employeeData);
                CorruptionChecking.checkEmployee(employeeDTO);
                line = bufferedReader.readLine();
            }
            System.out.println(duplicates);
            System.out.println(validEmployees);
//            for (int i = 0; i < employees.size(); i++) {
//                for (int j = 0; j < length; j++) {
////                    System.out.println(employees.get(i).getEmpID());
////                    System.out.println(j);
//                    if (duplicates.employees.get(i))) {
//                        duplicates.add(employees.get(i));
//                        counter++;
//                        continue;
////                        System.out.println(duplicates);
//                    }
//                    continue;
//                }
//            }
            return validEmployees;
        } catch (IOException e) {
            e.printStackTrace();
            ArrayList<EmployeeDTO> employees = new ArrayList<>();
            return employees;
        }
    }
}
