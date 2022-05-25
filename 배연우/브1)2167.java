import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] p;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] Args) throws IOException {
        //in and init
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = stoi(st);
        final int M = stoi(st);
        p = new int[N+1][M+1];
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < M+1; j++) {
                p[i][j] = stoi(st) + p[i][j-1];
            }
        }

        //getTestCase && makeReturn
        StringBuilder sb = new StringBuilder();
        int T = stoi(new StringTokenizer(br.readLine()));
        for (int a = 0; a < T; a++) {
            st = new StringTokenizer(br.readLine());
            int i = stoi(st);
            int j = stoi(st);

            int x = stoi(st);
            int y = stoi(st);

            int sum = 0;
            for (int k = i; k <= x; k++) {
                sum+= p[k][y] - p[k][j-1];
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }
}