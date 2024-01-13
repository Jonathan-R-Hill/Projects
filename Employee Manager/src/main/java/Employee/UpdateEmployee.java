package Employee;

import Objects.Employee;
import Utility.UserValidationCheck;
import Utility.ObjectSerialize;

import java.nio.file.Path;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class UpdateEmployee {

  private Employee currentEmployee;
  private Path filePath;
  private Scanner userInput;
  private ObjectSerialize saveReadObjects;

  public UpdateEmployee(Employee toUpdate, Path filePath, Scanner userInput, ObjectSerialize saveReadObjects) {
    this.currentEmployee = toUpdate;
    this.filePath = filePath;
    this.userInput = userInput;
    this.saveReadObjects = saveReadObjects;
  }

  private void updateAge() {
    while (true) {
      try {
        System.out.println("Enter the age to update to: ");
        int userChoice = userInput.nextInt();
        userInput.nextLine();

        if (userChoice > 0) {
          System.out.printf("Current age: %d.  New age: %d. %n", currentEmployee.getAge(), userChoice);
          if (UserValidationCheck.checkHappy(userInput, userChoice)) {
            currentEmployee.setAge(userChoice);
            break;
          }
        } else {
          System.out.println("Please enter an age greater than 0.");
        }

      } catch (InputMismatchException e) {
        System.out.println("Please enter a number.");
        userInput.next();
      }
    }
  }

  private void updateContact() {
    while (true) {
      System.out.println("Enter the contact number to update to: ");
      String userChoice = userInput.nextLine();

      System.out.printf("Current Contact Number: %s.  New Contact Number: %s. %n",
              currentEmployee.getContactNumber(), userChoice);

      if (UserValidationCheck.checkHappy(userInput, userChoice)) {
        currentEmployee.setContactNumber(userChoice);
        break;
      }
    }
  }

  private void updateDepartment(List<String> validDepartment, Map<String, String[]> validJobRoles) {
    while (true) {
      int counter = 0;
      for (String dept : validDepartment) {
        if (counter % 3 == 0 && counter != 0) {
          System.out.println();
        }
        System.out.print(dept + "   | ");
        counter++;
      }

      System.out.println("\nEnter the Department to update to. ");
      String userChoice = userInput.nextLine().toLowerCase();

      boolean validChoice = false;
      for (String dept : validDepartment) {
        if (userChoice.equals(dept.toLowerCase())) {
          System.out.printf("Current Department: %s.  New Department: %s. %n",
                  currentEmployee.getDepartment(), dept);

          if (UserValidationCheck.checkHappy(userInput, dept)) {
            validChoice = true;
            currentEmployee.setDepartment(dept);
            updateRole(validJobRoles, dept);
            break;
          }
        }
      }
      
      if (validChoice) {
        break;
      }
    }
  }

  private void updateRole(Map<String, String[]> validJobRoles, String dept) {
    int counter = 0;

    if (validJobRoles.containsKey(dept)) {
      for (String role : validJobRoles.get(dept)) {
        if (counter % 3 == 0 && counter != 0) {
          System.out.println();
        }
        System.out.print(role + "   | ");
        counter++;
      }
    }

    System.out.println("Please enter the new Job role of the employee");
    String employeeRole = userInput.nextLine().toLowerCase();

    if (validJobRoles.containsKey(dept)) {
      for (String role : validJobRoles.get(dept)) {
        if (employeeRole.equals(role.toLowerCase().strip()) && UserValidationCheck.checkHappy(userInput, role)) {
          currentEmployee.setJobRole(role);
        }
      }
    }
  }

  public void userSelection(List<String> validDepartment, Map<String, String[]> departmentRoles) {
    String userChoice = "";
    while (!userChoice.equals("age")
            && !userChoice.equals("contact number")
            && !userChoice.equals("department")
            && !userChoice.equals("job role")
            && !userChoice.equals("exit")) {
      System.out.println("\nWhat would you like to update? Chose from the following: ");
      System.out.println("age,  contact number,  department,  job role, exit");

      userChoice = userInput.nextLine().toLowerCase();
    }

    switch (userChoice) {
      case "age" -> {
        updateAge();
        userSelection(validDepartment, departmentRoles);
      }
      case "contact number" -> {
        updateContact();
        userSelection(validDepartment, departmentRoles);
      }
      case "department" -> {
        updateDepartment(validDepartment, departmentRoles);
        userSelection(validDepartment, departmentRoles);
      }
      case "job role" -> {
        updateRole(departmentRoles, currentEmployee.getDepartment());
        userSelection(validDepartment, departmentRoles);
      }
      case "exit" -> {
        saveReadObjects.serializeUpdateEmployee(currentEmployee, filePath.toString());
      }
    }

  }

}
