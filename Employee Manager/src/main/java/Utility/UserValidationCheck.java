package Utility;

import java.util.Scanner;

/**
 *
 * @author Jonathan Hill (d3344758)
 */
public class UserValidationCheck {

  public static boolean checkHappy(Scanner userInput, String param) {
    String checkHappy = "";
    while (!checkHappy.equals("yes") && !checkHappy.equals("no")) {
      System.out.println("Are you happy with your input: " + param + "?\t yes or no");
      checkHappy = userInput.nextLine().toLowerCase();
    }

    if (checkHappy.equals("yes")) {
      return true;
    }
    return false;
  }

  public static boolean checkHappy(Scanner userInput, int param) {
    String checkHappy = "";
    while (!checkHappy.equals("yes") && !checkHappy.equals("no")) {
      System.out.println("Are you happy with your input: " + param + "?\t yes or no");
      checkHappy = userInput.nextLine().toLowerCase();
    }

    if (checkHappy.equals("yes")) {
      return true;
    }
    return false;
  }

  public static boolean checkHappy(Scanner userInput, double param) {
    String checkHappy = "";
    while (!checkHappy.equals("yes") && !checkHappy.equals("no")) {
      System.out.println("Are you happy with your input: " + param + "?\t yes or no");
      checkHappy = userInput.nextLine().toLowerCase();
    }

    if (checkHappy.equals("yes")) {
      return true;
    }
    return false;
  }

  public static boolean checkHappy(Scanner userInput, float param) {
    String checkHappy = "";
    while (!checkHappy.equals("yes") && !checkHappy.equals("no")) {
      System.out.println("Are you happy with your input: " + param + "?\t yes or no");
      checkHappy = userInput.nextLine().toLowerCase();
    }

    if (checkHappy.equals("yes")) {
      return true;
    }
    return false;
  }
  
  public static boolean addAnother(Scanner userInput, String param) {
    String check = "";
    while (!check.equals("yes") && !check.equals("no")) {
      System.out.printf("Would you like to make another %s entry?\tyes or no\n", param);
      check = userInput.nextLine().toLowerCase().strip();
    }

    return check.equals("yes");
  }
}
