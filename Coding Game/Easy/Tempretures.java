import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        
        int closestNegative = -999999;
        int closestPositive = 999999;

        for (int i = 0; i < n; i++) {
            int temp = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if (temp < 0) {
                if (temp > closestNegative) {
                    closestNegative = temp;
                }
            } else {
                if ( temp < closestPositive) {
                    closestPositive = temp;
                }
            }
        }
        if (n == 0) {
            System.out.println('0');
        }
        else if ((closestNegative + 0) > (0 - closestPositive)) {
            System.out.println(closestNegative);
        } else {
            System.out.println(closestPositive);
        }

    }
}