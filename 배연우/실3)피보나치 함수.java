import java.util.Scanner;

class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int cnt = s.nextInt();
        for(int j = 0; j < cnt; j++) {
            int N = s.nextInt();
            int[][] fib = new int[N + 2][2];

            fib[0] = new int[]{1, 0};
            fib[1] = new int[]{0, 1};

            for (int i = 2; i <= N; i++) {
                int _1 = i - 1;
                int _2 = i - 2;
                fib[i][0] = fib[_1][0] + fib[_2][0];
                fib[i][1] = fib[_1][1] + fib[_2][1];
            }

            System.out.println(fib[N][0] + " " + fib[N][1]);
        }
    }
}