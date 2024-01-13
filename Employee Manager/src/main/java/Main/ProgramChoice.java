package Main;

import Employee.NewEmployee;
import Employee.UpdateEmployee;
import Objects.Employee;
import Utility.FileOperations;
import Utility.ObjectSerialize;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class ProgramChoice {

  private static Scanner userInput = new Scanner(System.in);

  protected static void createEmployee(int totalEmployees, ObjectSerialize saveReadObjects) {
    var fileIO = new FileOperations("Data.txt");
    Map<String, String[]> departmentRoles = fileIO.readDataFile();

    List<String> validDepartment = new ArrayList<>();
    for (Map.Entry<String, String[]> entry : departmentRoles.entrySet()) {
      validDepartment.add(entry.getKey());
    }

    Employee newEmployee = NewEmployee.createNewEmployee(validDepartment, departmentRoles);
    saveReadObjects.serializeNewEmployee(newEmployee, totalEmployees);
  }

  private static UpdateEmployee updateSelection(Map<Employee, Path> existingEmployees, ObjectSerialize saveReadObjects) {
    while (true) {
      String userChoice = "";
      for (Map.Entry<Employee, Path> entry : existingEmployees.entrySet()) {
        System.out.printf("Name: %s    Age: %d    Dept: %s    Role: %s%n",
                entry.getKey().getName(), entry.getKey().getAge(),
                entry.getKey().getDepartment(), entry.getKey().getJobRole());
      }
      System.out.println("Please pick an Employee from the list to update their details");
      userChoice = userInput.nextLine().strip();

      for (Map.Entry<Employee, Path> entry : existingEmployees.entrySet()) {
        if (userChoice.equals(entry.getKey().getName())) {
          return new UpdateEmployee(entry.getKey(), entry.getValue(), userInput, saveReadObjects);
        }
      }

      System.out.println("Please enter the name as it is shown");
    }
  }

  protected static void changeDetails(Map<Employee, Path> existingEmployees, ObjectSerialize saveReadObjects) {
    var fileIO = new FileOperations("Data.txt");
    Map<String, String[]> departmentRoles = fileIO.readDataFile();

    List<String> validDepartment = new ArrayList<>();
    for (Map.Entry<String, String[]> entry : departmentRoles.entrySet()) {
      validDepartment.add(entry.getKey());
    }

    var currentEmployee = updateSelection(existingEmployees, saveReadObjects);
    currentEmployee.userSelection(validDepartment, departmentRoles);
  }
}
