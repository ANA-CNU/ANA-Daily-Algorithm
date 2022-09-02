import java.util.*;
import java.io.*;


public class Main {
    static int N = 0;
    static int MC = 0;
    static int[][] Z048 = new int[N][N];
    static int[][] pv = new int[N][N];
    public static void sob0(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                boolean isZero=false;
                start = i;
                while (start + 1 < N && Z048[start + 1][j] == 0) start++;
                if (start + 1 < N && (Z048[start + 1][j] == Z048[i][j] || Z048[i][j]==0)) {
                    if(Z048[i][j]==0) isZero=true;
                    Z048[i][j] += Z048[start + 1][j];
                    Z048[start + 1][j] = 0;
                }
                if(isZero) i--;
            }
        }
    }

    public static void sob1(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                boolean isZero=false;
                start = i;
                while (start - 1 >=0 && Z048[start - 1][j] == 0) start--;
                if (start - 1 >=0 && (Z048[start - 1][j] == Z048[i][j] || Z048[i][j]==0)) {
                    if(Z048[i][j]==0) isZero=true;
                    Z048[i][j] += Z048[start - 1][j];
                    Z048[start - 1][j] = 0;
                }
                if(isZero) i++;
            }

        }
    }

    public static void sob2(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                boolean isZero=false;
                start = i;
                while (start + 1 < N && Z048[j][start + 1] == 0) start++;
                if (start + 1 < N && (Z048[j][start+1] == Z048[j][i]|| Z048[j][i]==0)) {
                    if(Z048[j][i]==0) isZero=true;
                    Z048[j][i] += Z048[j][start + 1];
                    Z048[j][start + 1] = 0;
                }
                if(isZero) i--;
            }
        }
    }

    public static void sob3(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                boolean isZero=false;
                start = i;
                while (start - 1 >= 0 && Z048[j][start - 1] == 0) start--;
                if (start - 1 >= 0 && (Z048[j][start - 1] == Z048[j][i]|| Z048[j][i]==0)) {
                    if(Z048[j][i]==0) isZero=true;
                    Z048[j][i] += Z048[j][start - 1];
                    Z048[j][start - 1] = 0;
                }
                if(isZero) i++;
            }
        }
    }

    public static void search(int n, int visited[]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Z048[i][j] = a[i][j];
                pv[i][j]=a[i][j];
            }
        }
        if (n == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    MC = Math.max(MC, Z048[i][j]);
                }
            }
            return;
        } else {
            for (int T = 0; T < 4; T++) {
                switch (T) {
                    case 0:
                        sob0(Z048); // 상
                        break;
                    case 1:
                        sob1(Z048); // 하
                        break;
                    case 2:
                        sob2(Z048); // 좌
                        break;
                    case 3:
                        sob3(Z048); // 우
                        break;
                }
                search(n + 1, Z048);

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++)
                        Z048[i][j] = pv[i][j];
                }
            }
        }
    }

    public static void initAndSearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Z048 = new int[N][N];
        pv= new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                Z048[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        search(0,{0,0,0,0});
    }

    public static void run() throws IOException {
        initAndSearch();
        System.out.println(MC);
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}