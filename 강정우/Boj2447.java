
import java.io.*;
public class Boj2447 {
    static void star(char[][] arr, int n, int x, int y) {
        if(arr[x][y]==' ')
            return;
        if (n == 1) {
            return;
        }
        n /= 3;
        for (int i = x + n; i < x + 2 * n; i++) {
            for (int j = y + n; j < y + 2 * n; j++) {
                arr[j][i] = ' ';
            }
        }
        for (int i = x; i < x + 3 * n; i += n) {
            for (int j = y; j < y + 3 * n; j += n) {
                star(arr, n, i, j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '*';
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        star(arr, n, 0, 0);
        for (int i = 0; i < n; i++) {
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
    }
}
