package Utility;

import Objects.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class ObjectSerialize {

  public void serializeNewEmployee(Employee person, int totalEmployees) {
    try {
      FileOutputStream fileOut = new FileOutputStream(
              System.getProperty("user.dir") + "/Employees/" + person.getName() + totalEmployees + ".ser");
      ObjectOutputStream file = new ObjectOutputStream(fileOut);
      file.writeObject(person);

      file.close();
      fileOut.close();
      System.out.println("Object saved!");
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  public void serializeUpdateEmployee(Employee person, String existingPath) {
    try {
      FileOutputStream fileOut = new FileOutputStream(existingPath);
      ObjectOutputStream file = new ObjectOutputStream(fileOut);
      file.writeObject(person);

      file.close();
      fileOut.close();
      System.out.println("Object Updated!");
    } catch (IOException i) {
      i.printStackTrace();
    }
  }

  public Map<Employee, Path> deserialize() {
    Map<Employee, Path> allEmployees = new HashMap<>();

    String directoryPath = System.getProperty("user.dir") + "/Employees/";

    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath), "*.ser")) {
      for (Path filePath : directoryStream) {
        allEmployees.put(deserializeEmployee(filePath), filePath);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return allEmployees;
  }

  private Employee deserializeEmployee(Path filePath) {
    Employee employee = null;

    try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath.toFile()))) {
      employee = (Employee) objectInputStream.readObject();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return employee;
  }
}
