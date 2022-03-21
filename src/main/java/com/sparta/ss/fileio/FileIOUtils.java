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
                writer.write(String.valueOf(employeeDTO));
                writer.write("\n");
                FileReader validReader = new FileReader("src/main/java/com/sparta/ss/fileio/ValidEntries.csv");
                BufferedReader validBufferedReader = new BufferedReader(validReader);
                validBufferedReader.readLine();
                String validLine = validBufferedReader.readLine();
                FileWriter corruptedWriter = new FileWriter("src/main/java/com/sparta/ss/fileio/CorruptedEntries.csv");
                while (validLine != null) {
                    String[] validEmployeeData = validLine.split(",");
                    System.out.println(Integer.parseInt(String.valueOf(validEmployeeData[0])));
                    if (Integer.parseInt(String.valueOf(validEmployeeData[0])) == employeeDTO.getEmpID()) {
                        corruptedWriter.write(String.valueOf(employeeDTO));
                        corruptedWriter.write("\n");
                        System.out.println("corrupted");
                    } else {
                        writer.write(String.valueOf(employeeDTO));
                        writer.write("\n");
                        System.out.println("valid");
                    }
                    System.out.println(employeeDTO);
                    validLine = validBufferedReader.readLine();
                    line = bufferedReader.readLine();
                }
//                if (employeeDTO.getEmpID()) {
//                    addFileCorrupted
//                } else {
//                    addFileGood
//                }
//                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
