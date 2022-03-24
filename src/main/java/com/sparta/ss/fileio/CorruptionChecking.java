package com.sparta.ss.fileio;

import java.util.ArrayList;

public class CorruptionChecking {
    public static ArrayList<EmployeeDTO> corruptedEmployees = new ArrayList<>();
    public static ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();

    public static void checkEmployee(EmployeeDTO employeeDTO) {
        if (idDuplicate(employeeDTO) || emailDuplicate(employeeDTO)) {
            corruptedEmployees.add(employeeDTO);
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

    public static boolean emailDuplicate(EmployeeDTO employeeDTO) {
        for (EmployeeDTO i : validEmployees) {
            if (i.getEmail() == employeeDTO.getEmail()) {
                return true;
            }
        }
        return false;
    }
}
