import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] graph;
    //graph에서 0,0이 1,1이다.

    public static void main(String[] Args) throws IOException {
        StringTokenizer st = getSt();
        int N = stoi(st);
        int M = stoi(st);

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) continue;
                graph[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < M; i++) {
            st = getSt();
            int a = stoi(st)-1;
            int b = stoi(st)-1;
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 0; i < N; i++) {
            fm(i);
        }

        int minIndex = 0;
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += graph[i][j];
            }
            if(minSum > sum) {
                minIndex = i;
                minSum = sum;
            }
        }

        System.out.println(minIndex+1);
    }

    static void fm(int tar) {
        int N = graph.length;
        for (int i = 0; i < N; i++) {
            if(i == tar) {
                continue;
            }
            for (int j = 0; j < N; j++) {
                if(j == tar || i == j) {
                    continue;
                }
                if(graph[i][tar] == Integer.MAX_VALUE || graph[tar][j] == Integer.MAX_VALUE) continue;
                int val = graph[i][tar] + graph[tar][j];
                graph[i][j] = Math.min(graph[i][j], val);
            }
        }
    }

    static int stoi(StringTokenizer st) {
        return Integer.parseInt(st.nextToken());
    }

    static StringTokenizer getSt() throws IOException{
        return new StringTokenizer(br.readLine());
    }
}