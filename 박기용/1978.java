import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int many = 0;

        for(int k = 1; k <= count; k++) {
            int num = sc.nextInt();
            int b = 0;

            for(int i = 2; i < num; i++) {
                if (num < 0) {
                    break;
                }

                if (num % i == 0) {
                    b = b + 1;
                }
            }
            if (num <= 1) {
                b = b + 1;
            }

            if (b == 0) {
                many++;
            }
        }
        System.out.println(many);
    }
}
