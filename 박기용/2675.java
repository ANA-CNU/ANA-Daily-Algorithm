import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] repeat = new int[num];
        String[] str = new String[num];
        char[] arr;

        for (int i = 0; i < num; i++) {
            repeat[i] = sc.nextInt();
            str[i] = sc.next();
        }

        for (int i = 0; i < num; i++) {
            arr = str[i].toCharArray();

            for (int j = 0; j < str[i].length(); j++) {
                for (int k = 0; k < repeat[i]; k++) {
                    System.out.print(arr[j]);
                }
            }
            System.out.println();
        }
    }
}
