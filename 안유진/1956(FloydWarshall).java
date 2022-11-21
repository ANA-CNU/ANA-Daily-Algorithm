import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    static int V;
    static int E;

    static int distance[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        distance = new int[V + 1][V + 1];

        for (int i = 0; i < V + 1; i++) {
            for (int j = 0; j < V + 1; j++) {
                distance[i][j] = 987654321;
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            distance[start][end] = cost;
        }

        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < V + 1; i++) {
            for (int j = 1; j < V + 1; j++) {
                if (distance[i][j] != 987654321 && distance[j][i] != 987654321) {
                    if (i == j && distance[i][j] != 0) {
                        min = Math.min(distance[i][j], min);
                    } else {
                        if (distance[i][j] != 0 && distance[j][i] != 0) {
                            min = Math.min(min, distance[i][j] + distance[j][i]);
                        }
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }
}
