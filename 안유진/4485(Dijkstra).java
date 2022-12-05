import java.util.*;
import java.io.*;

class Max {
    static int total;
    static int count = 1;

    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    public static void dijkstra(int n,int arr[][]) {
        boolean visited[][] = new boolean[n][n];
        int distance[][] = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                distance[i][j] = 987654321;
            }
        }

        Queue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.cost - o2.cost;
            }
        });
        queue.add(new Pair(0, 0, 0));

        distance[0][0] = 0;
        total += arr[0][0];

        while (!queue.isEmpty()) {
            Pair current = queue.remove();
            int currentX = current.x;
            int currentY = current.y;

            visited[currentX][currentY] = true;
            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < n) {
                    int nextCost = arr[nextX][nextY];
                    if(!visited[nextX][nextY] && distance[currentX][currentY] + nextCost < distance[nextX][nextY]) {
                        distance[nextX][nextY] = distance[currentX][currentY] + nextCost;
                        queue.add(new Pair(nextX, nextY, distance[nextX][nextY]));
                    }
                }
            }
        }

        total += distance[n - 1][n - 1];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) {
                break;
            }

            int arr[][] = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    arr[i][j] = temp;
                }
            }

            total = 0;
            dijkstra(N, arr);
            sb.append("Problem ").append(count).append(": ").append(total).append('\n');
            count++;
        }
        System.out.println(sb);
    }
}
class Pair{
    int x;
    int y;
    int cost;
    Pair(int x, int y, int c) {
        this.x = x;
        this.y = y;
        cost = c;
    }
}
