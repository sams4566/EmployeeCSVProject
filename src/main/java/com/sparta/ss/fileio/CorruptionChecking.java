package com.sparta.ss.fileio;

import java.util.ArrayList;
import java.util.Objects;

public class CorruptionChecking {
    public static ArrayList<EmployeeDTO> corruptedEmployees = new ArrayList<>();
    public static ArrayList<EmployeeDTO> validEmployees = new ArrayList<>();

    public static void checkEmployee(EmployeeDTO employeeDTO) {
        if (idDuplicate(employeeDTO, validEmployees) || emailDuplicate(employeeDTO, validEmployees) || genderCorrect(employeeDTO)) {
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

    public static boolean genderCorrect(EmployeeDTO employeeDTO) {
        if (Objects.equals(employeeDTO.getGender(), "M") || Objects.equals(employeeDTO.getGender(), "F")) {
            return false;
        }
        return true;
    }
}
