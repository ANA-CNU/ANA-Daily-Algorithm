import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int N;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {-1, 1, 0, 0};

    public static void bfs(int x, int y, int n){
        Queue<Pair> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair current = queue.remove();

            int currentX = current.start;
            int currentY = current.end;

            visited[currentX][currentY] = true;

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX >= 0 && nextX < N && nextY < N && nextY >= 0) {
                    if(!visited[nextX][nextY] && arr[nextX][nextY] > n) {
                        visited[nextX][nextY] = true;
                        queue.add(new Pair(nextX, nextY));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        arr = new int[N][N];

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                max = Math.max(max, temp);
            }
        }

        int answer = Integer.MIN_VALUE;

        while (max --> 0) {
            int count = 0;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && arr[i][j] > max) {
                        count++;
                        bfs(i, j, max);
                    }
                }
            }

            if(count > answer) {
                answer = count;
            }
        }

        System.out.println(answer);
    }
}
class Pair{
    int start;
    int end;
    Pair(int s, int e){
        start = s;
        end = e;
    }
}
