import java.util.*;


class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        while (true) {
            int max = 0;
            int tallest = 0;

            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.

                if (mountainH >= max) {
                    max = mountainH;
                    tallest = i;
                }
            }

            System.out.println(tallest);
        }
    }
}