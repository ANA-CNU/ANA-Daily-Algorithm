import java.util.*;
import java.io.*;

public class BOJ1915 {
    public static void main(String[] args) throws IOException{

        int max_square = 0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[n+1][m+1];

        String line;

        for (int i = 1; i <= n; i++) {
            line = br.readLine();
            for (int j = 1; j <= m; j++) {
                matrix[i][j] = line.charAt(j-1) - '0';
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1])) + 1;
                    max_square = Math.max(max_square, matrix[i][j]);
                }
            }
        }
        System.out.println(max_square*max_square);

    }
}
