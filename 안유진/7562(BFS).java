import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[][];
    static int arr[][];
    static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int targetX, targetY, count, N;

    public static void bfs(int start, int end) {
        Queue<Pair> queue = new LinkedList<>();

        visited[start][end] = true;
        arr[start][end]++;
        queue.add(new Pair(start, end));

        while (!queue.isEmpty()) {
            Pair current = queue.remove();

            if(current.x == targetX && current.y == targetY){
                break;
            }

            for(int i = 0; i < 8; i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                    continue;
                }

                if(!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    arr[nextX][nextY] = arr[current.x][current.y] + 1;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T --> 0) {
            N = Integer.parseInt(br.readLine());

            visited = new boolean[N][N];
            arr = new int[N][N];
            count = 0;

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            bfs(start, end);

            sb.append(arr[targetX][targetY] - 1).append('\n');
        }

        System.out.println(sb);
    }
}
class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
