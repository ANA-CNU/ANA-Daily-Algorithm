import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[][] field;
    static int N, M;
    static int K;
    public static void main(String[] Args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            //초기화
            N = 0; M = 0; K = 0;
            //입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = stoi(st);
            M = stoi(st);
            K = stoi(st);
            field = new boolean[N][M];
            for(int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = stoi(st);
                int y = stoi(st);
                field[x][y] = true;
            }
            //계산
            int ret = floodFill();
            //출력
            System.out.println(ret);
        }
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static int floodFill() {
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(field[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        return cnt;
    }

    static void dfs(int i, int j) {
        if(!field[i][j]) {
            return;
        }

        field[i][j] = false;
        dfs_try(i-1, j);
        dfs_try(i+1, j);
        dfs_try(i, j-1);
        dfs_try(i, j+1);
    }

    static void dfs_try(int i, int j) {
        try {
            dfs(i, j);
        } catch (Exception E) {
            return;
        }
    }
}