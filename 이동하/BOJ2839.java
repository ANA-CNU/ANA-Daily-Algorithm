import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (input == 0) {
            System.out.println(-1);
            System.exit(0);
        }
        int count = 0;
        int N = input;

        while (N - 5 >= 0) {
            if (N == 0) {
                System.out.println(count);
                System.exit(0);
            } else {
                N -= 5;
                count++;
            }
        }
        if (N == 0) {
            System.out.println(count);
            System.exit(0);
        }
        while (N - 3 >= 0) {
            if (N == 0) {
                System.out.println(count);
                System.exit(0);
            } else {
                N -= 3;
                count++;
            }
        }
        if (N == 0) {
            System.out.println(count);
            System.exit(0);
        }
        N = input;
        count = 0;

        while (N - 3 >= 0) {
            if (N == 0) {
                System.out.println(count);
                System.exit(0);
            } else {
                if (N%5 != 0) {
                    N -= 3;
                    count++;
                } else {
                    break;
                }
            }
        }
        if (N == 0) {
            System.out.println(count);
            System.exit(0);
        }
        while (N - 5 >= 0) {
            if (N == 0) {
                System.out.println(count);
                System.exit(0);
            } else {
                N -= 5;
                count++;
            }
        }
        if (N == 0) {
            System.out.println(count);
            System.exit(0);
        } else {
            System.out.println(-1);
        }
    }
}
