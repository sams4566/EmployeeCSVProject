package com.sparta.ss.fileio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class CorruptionChecking {
    public static ArrayList<EmployeeDTO> corruptedEmployees = new ArrayList<>();
    public static ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();

    public static void checkEmployee(EmployeeDTO employeeDTO) {
        if (idDuplicate(employeeDTO, validEmployees) || emailDuplicate(employeeDTO, validEmployees) || genderIncorrect(employeeDTO)) {
            corruptedEmployees.add(employeeDTO);
        } else {
            validEmployees.add(employeeDTO);
        }
    }

    public static boolean idDuplicate(EmployeeDTO employeeDTO, ArrayList<EmployeeDTO> validEmployees) {
        for (EmployeeDTO i : validEmployees) {
            if (employeeDTO.getEmpID() == i.getEmpID()) {
                return true;
            }
        }
        return false;
    }

    public static boolean emailDuplicate(EmployeeDTO employeeDTO, ArrayList<EmployeeDTO> validEmployees) {
        for (EmployeeDTO i : validEmployees) {
            if (i.getEmail() == employeeDTO.getEmail()) {
                return true;
            }
        }
        return false;
    }

    public static boolean genderIncorrect(EmployeeDTO employeeDTO) {
        String gender = "M";
        System.out.println(gender);
        System.out.println(employeeDTO.getGender());
        if (employeeDTO.getGender() == gender) {
            return true;
        }
        return false;
    }
}
