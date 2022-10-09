import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

class Pair{
    private int x;
    private int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

public class Main {
    static int N;
    static int M;

    static int arr[][];
    static boolean visited[][];

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static Queue<Pair> queue = new LinkedList<>();
    public static void BFS(){
        queue.add(new Pair(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()){
            Pair p = queue.remove();
            int currentX = p.getX();
            int currentY = p.getY();

            for(int i = 0; i < 4; i++){
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if(nextX >= N || nextX < 0 || nextY >= M || nextY < 0){
                    continue;
                }
                if(!visited[nextX][nextY] && arr[nextX][nextY] != 0){
                    arr[nextX][nextY] = arr[currentX][currentY] + 1;
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());

       arr = new int[N][M];
       visited = new boolean[N][M];

       for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
       }
       BFS();
       System.out.println(arr[N - 1][M - 1]);
    }
}
