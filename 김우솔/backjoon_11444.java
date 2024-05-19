package Fibo;

import java.io.*;

public class backjoon_11444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long num = Long.parseLong(br.readLine()) - 1;
        long[][] fibo1 = new long[][]{
                {1, 1},
                {1, 0}
        };
        long[][] remain = new long[][]{
                {1, 0},
                {0, 1}
        };
        while (num > 1) {
            if (num % 2 == 0) {
                fibo1 = Matrix(fibo1, fibo1);
                num /= 2;
            } else {
                remain = Matrix(remain, fibo1);
                fibo1 = Matrix(fibo1, fibo1);
                num /= 2;
            }
        }
        fibo1 = Matrix(remain, fibo1);
        bw.write(fibo1[0][0] % 1000000007 + "\n");
        bw.flush();
        bw.close();
    }

    static long[][] Matrix(long[][] a, long[][] b) {
        long[][] ans = new long[2][2];//가로, 세로, 행, 열
        ans[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 1000000007;
        ans[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 1000000007;
        ans[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 1000000007;
        ans[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 1000000007;
        return ans;
    }
}