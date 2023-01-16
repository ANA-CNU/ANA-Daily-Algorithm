import java.io.*;
import java.util.*;

public class Hororop {
    static boolean visited[];
    static int cost[];

    static int dx[] = {-1, 1};
    public static void bfs(int start, int target){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        cost[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.remove();

            if(current == target){
                break;
            }

            for (int i = 0; i < 2; i++){
                int index = current + dx[i];
                if(index >= 0 && index <= 100000 && !visited[index]){
                    visited[index] = true;
                    queue.add(index);
                    cost[index] = cost[current] + 1;
                }
            }

            int index = current * 2;
            if(index >= 0 && index <= 100000 && !visited[index]){
                visited[index] = true;
                queue.add(index);
                cost[index] = cost[current] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        cost = new int[100001];

        bfs(N, K);

        System.out.println(cost[K]);
    }
}
