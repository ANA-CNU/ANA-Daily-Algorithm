import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        String num = sc.nextLine();

        double square;
        double sum = 0;
        String str;

        for (int i = 0; i < 5; i++) {
            char a = num.charAt(i);
            str = String.valueOf(a);
            int count = Integer.parseInt(str);
            arr[i] = count;
        }

        for (int j = 0; j < 5; j++) {
            square = arr[j];
            square = Math.pow(square, 5);
            sum = sum + square;
        }

        int sum1 = (int) sum;

        System.out.println(sum1);
    }
}
