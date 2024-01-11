package Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class FileOperations {

  private final String fileName;

  public FileOperations(String fileName) {
    this.fileName = fileName;
  }

  public Map<String, String[]> readDataFile() {
    Map<String, String[]> departmentRoles = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("\t");

        if (parts.length == 2) {
          departmentRoles.put(parts[0], parts[1].split(","));
        }

      }
    } catch (FileNotFoundException error) {
      error.printStackTrace();
    } catch (IOException error) {
      error.printStackTrace();
    }
    return departmentRoles;
  }

  public void writeToFile(String information) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
      writer.append(information);
      System.out.println("Write operation was successful.");
    } catch (IOException error) {
      error.printStackTrace();
    }
  }
}
