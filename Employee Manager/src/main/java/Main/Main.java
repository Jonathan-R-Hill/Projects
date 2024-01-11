package Main;

import Objects.Employee;
import Utility.ObjectSerialize;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class Main {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    var saveReadObjects = new ObjectSerialize();
    List<Employee> allEmployees = saveReadObjects.deserialize();
    int totalEmployees = allEmployees.size();

    String userChoice = "";
    while (!userChoice.equals("new employee") && !userChoice.equals("ne")
            && !userChoice.equals("show all employee names") && !userChoice.equals("saen")) {
      
      System.out.println("""
                         Choose from the following:
                         Enter: new employee\t OR Enter: ne
                         Enter: show all employee names\t OR Enter: saen""");
      userChoice = userInput.nextLine().toLowerCase();
    }

    switch (userChoice) {
      case "newemployee", "ne" ->
        ProgramChoice.createEmployee(totalEmployees, saveReadObjects);
      case "show all employee names", "saen" ->
        ProgramChoice.showAllNames(allEmployees);
    }

  }
}
