package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus {
    int x;
    int y;
    Virus(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Q14502 {
    static int N, M, answer = 0;
    static int[][] graph;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0);
        System.out.println(answer);
    }

    static void DFS(int L) {
        if (L == 3) {
            BFS();
            return;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (graph[i][j] == 0) {
                        graph[i][j] = 1;
                        DFS(L + 1);
                        graph[i][j] = 0;
                    }
                }
            }
        }
    }
    static void BFS() {
        int[][] virusMap = new int[N][M];
        Queue<Virus> Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = graph[i][j];
                if (virusMap[i][j] == 2) Q.offer(new Virus(i, j));
            }
        }
        while (!Q.isEmpty()){
            Virus cv = Q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cv.x + dx[i];
                int ny = cv.y + dy[i];
                if(nx>=0 && nx < N && ny >=0 && ny < M && virusMap[nx][ny] == 0){
                    virusMap[nx][ny] = 2;
                    Q.offer(new Virus(nx,ny));
                }
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(virusMap[i][j] == 0) count ++;
            }
        }
        answer = Math.max(count, answer);
    }
}
