package com.sparta.ss.fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIOUtils {
    static void readFile(String fileName) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            FileWriter writer = new FileWriter("src/main/java/com/sparta/ss/fileio/ValidEntries.csv");
//            FileWriter corruptedWriter = new FileWriter("src/main/java/com/sparta/ss/fileio/CorruptedEntries.csv");
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
//                FileWriter writer = new FileWriter("src/main/java/com/sparta/ss/fileio/ValidEntries.csv");
                System.out.println(employeeDTO);
                line = bufferedReader.readLine();
                writer.write(String.valueOf(employeeDTO));
                writer.write("\n");
//                FileReader validReader = new FileReader(fileName);
//                BufferedReader validBufferedReader = new BufferedReader(validReader);
//                validBufferedReader.readLine();
//                String validLine = validBufferedReader.readLine();
//                int counter = 0;
//                while (validLine != null) {
//                    String[] validEmployeeData = validLine.split(",");
//                    EmployeeDTO validEmployeeDTO = new EmployeeDTO(
//                            validEmployeeData[0],
//                            validEmployeeData[1],
//                            validEmployeeData[2],
//                            validEmployeeData[3],
//                            validEmployeeData[4],
//                            validEmployeeData[5],
//                            validEmployeeData[6],
//                            validEmployeeData[7],
//                            validEmployeeData[8],
//                            validEmployeeData[9]
//                    );
////
//                    if (employeeDTO.getEmpID() == validEmployeeDTO.getEmpID()) {
//                        System.out.println("uncorrupted");
//                        System.out.println(employeeDTO.getEmpID());
//                        counter++;
//                        System.out.println(counter);
//                        if (counter > 1) {
//                            System.out.println(String.valueOf(employeeDTO));
//                            corruptedWriter.write(String.valueOf(employeeDTO));
//                            corruptedWriter.write("\n");
//                            System.out.println("corrupted er gerw gwreg er greg werg ergregre werg wreg erg erg reg werg ewg ");
//                        }
//                    } else {
//                        System.out.println("hello");
//                    }
////                    System.out.println(employeeDTO);
//                    validLine = validBufferedReader.readLine();
////                    line = bufferedReader.readLine();
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
