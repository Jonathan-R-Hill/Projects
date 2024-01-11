package Main;

import Employee.NewEmployee;
import Objects.Employee;
import Utility.FileOperations;
import Utility.ObjectSerialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class ProgramChoice {

  protected static void createEmployee(int totalEmployees, ObjectSerialize saveReadObjects) {
    var fileIO = new FileOperations("Data.txt");
    Map<String, String[]> departmentRoles = fileIO.readDataFile();

    // Create valid departments
    List<String> validDepartment = new ArrayList<>();
    for (Map.Entry<String, String[]> entry : departmentRoles.entrySet()) {
      validDepartment.add(entry.getKey());
    }

    Employee newEmployee = NewEmployee.createNewEmployee(validDepartment, departmentRoles);
    saveReadObjects.serialize(newEmployee, totalEmployees);
  }

  protected static void showAllNames(List<Employee> existingEmployees) {
    for (Employee obj : existingEmployees) {
      System.out.println(obj.getName());
    }
  }
}
