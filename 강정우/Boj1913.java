import java.io.BufferedReader;
import java.util.*;
import java.io.*;

public class Boj1913 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int value = 1;
        int x = n / 2, y = n / 2;
        int tmp1 = 0, tmp2 = 0;
        int limit = 1;
        while (true) {
            for (int i = 0; i < limit; i++) {
                map[y][x] = value;
                if (value == m) {
                    tmp1 = y + 1;
                    tmp2 = x + 1;
                }
                y--;
                value++;
            }
            if (value - 1 == n * n)
                break;
            for (int i = 0; i < limit; i++) {
                map[y][x] = value;
                if (value == m) {
                    tmp1 = y + 1;
                    tmp2 = x + 1;
                }
                x++;
                value++;
            }

            limit++;
            for (int i = 0; i < limit; i++) {
                map[y][x] = value;
                if (value == m) {
                    tmp1 = y + 1;
                    tmp2 = x + 1;
                }
                y++;
                value++;
            }

            for (int i = 0; i < limit; i++) {
                map[y][x] = value;
                if (value == m) {
                    tmp1 = y + 1;
                    tmp2 = x + 1;
                }
                x--;
                value++;
            }
            limit++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++)
                sb.append(map[i][j] + " ");
            sb.append(map[i][n - 1] + "\n");
        }
        System.out.print(sb);
        System.out.println(tmp1 + " " + tmp2);
    }
}
