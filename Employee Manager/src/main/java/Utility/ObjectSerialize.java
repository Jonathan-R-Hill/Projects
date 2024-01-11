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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class ObjectSerialize {

  public void serialize(Employee person, int totalEmployees) {
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

  public List<Employee> deserialize() {
    List<Employee> allEmployees = new ArrayList<>();

    String directoryPath = System.getProperty("user.dir") + "/Employees/";

    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directoryPath), "*.ser")) {
      for (Path filePath : directoryStream) {
        allEmployees.add(deserializeEmployee(filePath));
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
