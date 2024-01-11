package Employee;

import Objects.Employee;
import Utility.UserValidationCheck;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class NewEmployee {

  private static Scanner userInput = new Scanner(System.in);

  private static String nameInput() {
    while (true) {
      System.out.println("Please enter the full name of the employee");
      String name = userInput.nextLine();

      if (UserValidationCheck.checkHappy(userInput, name)) {
        return name;
      }
    }
  }

  private static int ageInput() {
    while (true) {
      try {
        System.out.println("Please enter the age of the employee");
        int age = userInput.nextInt();

        if (age <= 0) {
          System.out.println("Please enter an age over 0");
        } else {
          userInput.nextLine();
          if (UserValidationCheck.checkHappy(userInput, age)) {
            return age;
          }
        }
      } catch (InputMismatchException e) {
        System.out.println("Please only enter numbers");
        userInput.nextLine();
      }
    }
  }

  private static String contactNumInput() {
    while (true) {
      System.out.println("Please enter the contact number for the employee");
      String number = userInput.nextLine();

      if (UserValidationCheck.checkHappy(userInput, number)) {
        return number;
      }
    }
  }

  private static String departmentInput(List<String> validDepartments) {
    while (true) {
      int counter = 0;
      for (String dept : validDepartments) {
        if (counter % 3 == 0 && counter != 0) {
          System.out.println();
        }
        System.out.print(dept + "   | ");
        counter++;
      }

      System.out.println("Please enter the department of the employee");
      String userDept = userInput.nextLine().toLowerCase();

      for (String dept : validDepartments) {
        if (userDept.equals(dept.toLowerCase())) {
          if (UserValidationCheck.checkHappy(userInput, dept)) {
            return dept;
          }
          break;
        }
      }
    }
  }

  private static String jobRoleInput(Map<String, String[]> validJobRoles, String dept) {
    while (true) {
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

      System.out.println("Please enter the Job role of the employee");
      String employeeRole = userInput.nextLine().toLowerCase();

      if (validJobRoles.containsKey(dept)) {
        for (String role : validJobRoles.get(dept)) {
          if (employeeRole.equals(role.toLowerCase().strip()) && UserValidationCheck.checkHappy(userInput, role)) {
            return role;
          }
        }
      }

      System.out.println("Invalid Entry.\n");
    }
  }

  public static Employee createNewEmployee(List<String> validDepartments, Map<String, String[]> validJobRoles) {
    String name = nameInput();
    int age = ageInput();
    String contactNum = contactNumInput();
    String dept = departmentInput(validDepartments);
    String jobRole = jobRoleInput(validJobRoles, dept);

    return new Employee(name, age, contactNum, dept, jobRole);
  }

}
