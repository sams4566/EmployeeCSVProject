package com.sparta.ss.fileio;

import java.util.ArrayList;

public class CorruptionChecking {
    public static ArrayList<EmployeeDTO> duplicates = new ArrayList<>();
    public static ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();

    public static void checkEmployee(EmployeeDTO employeeDTO) {
        if (idDuplicate(employeeDTO) || emailDuplicate(employeeDTO)) {
            duplicates.add(employeeDTO);
        } else {
            validEmployees.add(employeeDTO);
        }
    }

    public static boolean idDuplicate(EmployeeDTO employeeDTO) {
        for (EmployeeDTO i : validEmployees) {
            if (employeeDTO.getEmpID() == i.getEmpID()) {
                return true;
            }
        }
        return false;
    }

    private static boolean emailDuplicate(EmployeeDTO employeeDTO) {
        for (EmployeeDTO i : validEmployees) {
            if (i.getEmail() == employeeDTO.getEmail()) {
                return true;
            }
        }
        return false;
    }
}
