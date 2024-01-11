package Objects;

import java.io.Serializable;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class Employee implements Serializable {
  
  private String name;
  private int age;
  private String department;
  private String contactNumber;
  private String jobRole;

  public Employee(String name, int age, String contactNumber, String department, String jobRole) {
    this.name = name;
    this.age = age;
    this.contactNumber = contactNumber;
    this.department = department;
    this.jobRole = jobRole;
  }
  
  // ---------- Getters/Setters below ---------- //

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getJobRole() {
    return jobRole;
  }

  public void setJobRole(String jobRole) {
    this.jobRole = jobRole;
  }
  
  
}
