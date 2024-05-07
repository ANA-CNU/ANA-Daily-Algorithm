import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] realdiv = new int[count];

        for (int i = 0; i < count; i++) {
            realdiv[i] = sc.nextInt();
        }

        int max = 0;
        int min = 1500000000;

        for (int i = 0; i < count; i++) {
            max = Math.max(max, realdiv[i]);
            min = Math.min(min, realdiv[i]);
        }

        int result = max * min;

        System.out.println(result);
    }
}
