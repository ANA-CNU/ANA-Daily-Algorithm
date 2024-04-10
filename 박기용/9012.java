import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        String a = sc.nextLine();

        for (int i = 0; i < count; i++) {
            int pair = 0;
            char[] arr = sc.nextLine().toCharArray();

            for (int j = 0; j < arr.length; j++) {
                for (int k = j; k < arr.length; k++) {
                    if (arr[j] == '(') {
                        if (arr[k] == ')') {
                            arr[k] = '.';
                            pair++;
                            break;
                        }
                    }
                }
            }

            if ((double) pair == (double) arr.length/2) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
