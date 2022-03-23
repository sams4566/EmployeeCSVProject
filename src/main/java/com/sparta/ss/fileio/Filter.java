package com.sparta.ss.fileio;

import java.util.ArrayList;
import java.util.Collections;

public class Filter {

    private static ArrayList<EmployeeDTO> validatedEmployees = new ArrayList<EmployeeDTO>();
    private static ArrayList<EmployeeDTO> duplicateEntries = new ArrayList<EmployeeDTO>();

    public static void sortList(ArrayList<EmployeeDTO> employees) {
        for (EmployeeDTO employee : employees) {
            if (Collections.frequency(employees, employee.getEmpID()) > 1){
                duplicateEntries.add(employee);
            } else {
                validatedEmployees.add(employee);
            }
        }
    }

    public static ArrayList getValidatedEmployees() {
        return validatedEmployees;
    }

    public static ArrayList getDuplicateEntries() {
        return duplicateEntries;
    }
}





//        for (EmployeeDTO employee.empID() : employees) {
//            if (employees getEmpID ){
//            }
//            System.out.println(employee.getEmpID());
//        }
//
//        // Function to remove duplicates from an ArrayList, starting with ID first, then email if time
//        public static <T> ArrayList < T > removeDuplicates(ArrayList < T > list)
//        {
//            // Create a new ArrayList
//            ArrayList<T> newList = new ArrayList<T>();
//            // Traverse through the first list
//            for (T element : list) {
//                // If this element is not present in newList
//                // then add it
//                if (!newList.contains(element)) {
//                    newList.add(element);
//                }
//            }
//
//            // return the new list
//            return newList;
//        }
//
//        // Driver code
//        public static void main (String args[])
//        {
//
//            // Get the ArrayList with duplicate values
//            ArrayList<Integer>
//                    list = new ArrayList<>(
//                    Arrays.asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));
//
//            // Print the Arraylist
//            System.out.println("ArrayList with duplicates: "
//                    + list);
//
//            // Remove duplicates
//            ArrayList<Integer>
//                    newList = removeDuplicates(list);
//
//            // Print the ArrayList with duplicates removed
//            System.out.println("ArrayList with duplicates removed: "
//                    + newList);
//        }
//    }
//
//}



//    public static void sortLists(ArrayList<EmployeeDTO> employee1, ArrayList<EmployeeDTO> employee2) {
//        ArrayList<EmployeeDTO> validatedEmployees = new ArrayList<EmployeeDTO>();
//        ArrayList<EmployeeDTO> corruptedEntries = new ArrayList<EmployeeDTO>();
//        for (EmployeeDTO employee : ) {
//
//            System.out.println(employee.getEmpID());
//        }



//create loop going through that list comparing the two arrays with the .getID method


//add any that are the same

//    FileReader validReader = new FileReader("src/main/java/com/sparta/ss/fileio/ValidEntries.csv");
//    BufferedReader validBufferedReader = new BufferedReader(validReader);
//                validBufferedReader.readLine();
//    String validLine = validBufferedReader.readLine();
//    FileWriter corruptedWriter = new FileWriter("src/main/java/com/sparta/ss/fileio/CorruptedEntries.csv");
//                while (validLine != null) {
//        String[] validEmployeeData = validLine.split(",");
//        System.out.println(Integer.parseInt(String.valueOf(validEmployeeData[0])));
//        if (Integer.parseInt(String.valueOf(validEmployeeData[0])) == employeeDTO.getEmpID()) {
//            corruptedWriter.write(String.valueOf(employeeDTO));
//            corruptedWriter.write("\n");
//            System.out.println("corrupted");
//        } else {
//            writer.write(String.valueOf(employeeDTO));
//            writer.write("\n");
//            System.out.println("valid");
//        }
//        System.out.println(employeeDTO);
//        validLine = validBufferedReader.readLine();
//        line = bufferedReader.readLine();


//                if (employeeDTO.getEmpID()) {
//                    addFileCorrupted
//                } else {
//                    addFileGood
//                }
//                line = bufferedReader.readLine();


//
//    private static int employeeCount = 0;
//    private String[] employeesList = new String[employeeCount];
//
//    public static String[] employeeInfo(String[] employeeData){
//        while(employeeData != null){
//            for(//each  in employee data)
//
//                if(){
//                    //fdsfs
//
//            }
//            employeeCount ++;
//        }
//    }


