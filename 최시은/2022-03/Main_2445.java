import java.util.Scanner;

public class Main_2445 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int star = i + 1;
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - star; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - star; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

        for (int i = n - 2; i >= 0; i--) {

            int star = i + 1;
            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - star; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < n - star; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < star; j++) {
                System.out.print("*");
            }

            System.out.println();

        }

    }
}
