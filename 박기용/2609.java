import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = 2;
        int max = 1;
        int min = 1;

        while (true) {
            if (a%c == 0 && b%c == 0) {
                a /= c; b /= c;
                max *= c; min *= c;
            } else {
                if (c > a || c > b) {
                    max *= a * b;
                    break;
                }
                c++;
            }
        }

        System.out.print(min + "\n" + max);
    }
}
