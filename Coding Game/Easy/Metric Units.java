import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Scanner;

class Solution {

    static String[] convertArrays(String expression) {
        String[] initialSplit = expression.split("\\+");
        String[] resultArray = new String[initialSplit.length];

        for (int i = 0; i < initialSplit.length; i++) {
            resultArray[i] = initialSplit[i].trim();
        }

        return resultArray;
    }

    static String[][] splitNumbers(String[] resultArray) {
        String[][] splitNumbers = new String[resultArray.length][2];

        for (int i = 0; i < resultArray.length; i++) {

            String[] parts = resultArray[i].split("(?<=\\d)(?=[^\\d.])");
            
            if (parts.length == 2) {
                splitNumbers[i][0] = parts[0];
                splitNumbers[i][1] = parts[1];
            } 
            else if (parts.length == 1) {
                splitNumbers[i][0] = parts[0];
                splitNumbers[i][1] = ""; // 비어 있으면 
            }
        }

        return splitNumbers;
    }

    static double convertToUM(String[][] splitNumbers) {
    double totalUM = 0.0;

    for (int i = 0; i < splitNumbers.length; i++) {
        // Extract the unit and value from the current row
        String unit = splitNumbers[i][1];
        double value = Double.parseDouble(splitNumbers[i][0]);

        switch (unit) {
            case "um":
                totalUM += value;
                break;
            case "mm":
                totalUM += value * 1000;
                break;
            case "cm":
                totalUM += value * 10 * 1000;
                break;
            case "dm":
                totalUM += value * 10 * 10 * 1000;
                break;
            case "m":
                totalUM += value * 10 * 10 * 10 * 1000;
                break;
            case "km":
                totalUM += value * 1000 * 10 * 10 * 10 * 1000;
                break;
            default:
                System.out.println("Unsupported unit: " + unit);
                break;
            }
        }

        return totalUM;
    }

    static String convertToRequiredType(String[][] splitNumbers, double totalUM) {
        double converted = 0.0;
        String convertToUnit = "km";
        String answer = "";
        int convertionValue = 5;    // 0 = um  1 = cm .....

        for (int i = 0; i < splitNumbers.length; i++) {
            String unit = splitNumbers[i][1];

            switch (unit) {
                case "um":
                    if (convertionValue >= 0) {
                        convertionValue = 0;
                        convertToUnit = "um";
                    }
                    break;
                case "mm":
                    if (convertionValue >= 1) {
                        convertionValue = 1;
                        convertToUnit = "mm";
                    }
                    break;
                case "cm":
                    if (convertionValue >= 2) {
                        convertionValue = 2;
                        convertToUnit = "cm";
                    }
                    break;
                case "dm":
                    if (convertionValue >= 3) {
                        convertionValue = 3;
                        convertToUnit = "dm";
                    }
                    break;
                case "m":
                    if (convertionValue >= 4) {
                        convertionValue = 4;
                        convertToUnit = "m";
                    }
                    break;
                case "km":
                    if (convertionValue >= 5) {
                        convertionValue = 5;
                        convertToUnit = "km";
                    }
                    break;
                default:
                    System.out.println("Unsupported unit: " + unit);
                    break;
            }
        }
        

        switch (convertionValue) {
            case 0:
                converted = totalUM;
                break;
            case 1:
                converted = totalUM / 1000;
                break;
            case 2:
                converted = totalUM / 1000 / 10;
                break;
            case 3:
                converted = totalUM / 1000 /10 / 10;
                break;
            case 4:
                converted = totalUM / 1000 /10 /10 /10;
                break;
            case 5:
                converted = totalUM / 1000 /10 /10 /10 / 1000;
                break;
        }


    String valueStr = Double.toString(converted);

    if (valueStr.contains(".")) {
        // Split the string at the decimal point
        String[] parts = valueStr.split("\\.");

        if (parts.length > 1) {
            String decimalPart = parts[1];
            
            // Check if the decimal part contains any digit other than 0
            for (char c : decimalPart.toCharArray()) {
                if (c != '0') {
                    float intValue = (float) converted;
                    answer = intValue + convertToUnit;
                    break;
                }
                else {
                    int intValue = (int) converted;
                    answer = intValue + convertToUnit;
                }
            }
        }
    }
        
        return answer;
    }


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in); // Uncomment this line
        String expression = in.nextLine(); // the expression to calculate
        
        String[] result = convertArrays(expression);
        String[][] splitNumbers = splitNumbers(result);

        double totalUM = convertToUM(splitNumbers);

        String answer = convertToRequiredType(splitNumbers, totalUM);
        System.out.println(answer);
    }

}
