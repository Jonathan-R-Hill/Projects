package Main;

import Objects.Employee;
import Utility.ObjectSerialize;

import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class Main {

  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    var saveReadObjects = new ObjectSerialize();
    Map<Employee, Path> allEmployees = saveReadObjects.deserialize();
    int totalEmployees = allEmployees.size();

    String userChoice = "";
    while (!userChoice.equals("new employee") && !userChoice.equals("ne")
            && !userChoice.equals("update employee") && !userChoice.equals("ue")) {
      
      System.out.println("""
                         Choose from the following:
                         Enter: new employee\t OR Enter: ne
                         Enter: update employee\t OR Enter: ue""");
      userChoice = userInput.nextLine().toLowerCase();
    }

    switch (userChoice) {
      case "new employee", "ne" ->
        ProgramChoice.createEmployee(totalEmployees, saveReadObjects);
      case "update employee", "ue" ->
        ProgramChoice.changeDetails(allEmployees, saveReadObjects);
    }

  }
}
