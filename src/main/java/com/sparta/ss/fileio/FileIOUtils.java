package com.sparta.ss.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileIOUtils {
    static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            FileWriter writer = new FileWriter("src/main/java/com/sparta/ss/fileio/ValidEntries.csv");
            FileWriter corruptedWriter = new FileWriter("src/main/java/com/sparta/ss/fileio/CorruptedEntries.csv");
            ArrayList<EmployeeDTO> employees = new ArrayList<>();
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
                employees.add(employeeDTO);
                line = bufferedReader.readLine();
            }
//            System.out.println(employees.get(0).getEmpID());
            ArrayList<EmployeeDTO> duplicates = new ArrayList<>();
            int counter = 0;
            duplicates.add(employees.get(0));
            System.out.println(employees.size());
//            for (int i = 0; i < employees.size(); i++) {
//                for (int j = 0; j < duplicates.size(); j++) {
////                    System.out.println(employees.get(i).getEmpID());
//                    System.out.println(j);
//                    if (duplicates.add(employees.get(i))) {
//                        duplicates.add(employees.get(i));
//                        counter++;
//                        continue;
////                        System.out.println(duplicates);
//                    }
//                    continue;
//                }
//            }
            System.out.println(duplicates);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
