import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(s.nextToken());
        int W = Integer.parseInt(s.nextToken());
        int ans = 0;
        boolean[][] a = new boolean[H + 1][W];

        for (int i = 0; i < W; i++) {
            int h = Integer.parseInt(ss.nextToken());
            for (int j = 0; j <= h; j++) {
                a[j][i] = true;
            }
        }

        for (int i = H; i > 0; i--) {
            int j = W - 1;
            int start = -1;
            int end = -1;
            while (j >= 0) {
                while (j >= 0 && !a[i][j]) j--;
                if (j >= 0) start = j;

                j = start - 1;

                while (j >= 0 && !a[i][j]) j--;
                if (j >= 0) end = j;

                if (j<0) {
                    break;
                } else{
                    ans += start - end-1;
                    j=end;
                }
            }
        }

        System.out.println(ans);
    }
}
