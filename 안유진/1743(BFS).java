import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Pair{
    private final int x;
    private final int y;
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

    static int count = 1;

    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        while (!queue.isEmpty()){
            Pair p = queue.remove();
            visited[p.getX()][p.getY()] = true;

            for(int i = 0; i < 4; i++){
                int tempX = p.getX() + dx[i];
                int tempY = p.getY() + dy[i];

                if(tempX >= 0 && tempY >= 0 && tempX <= N-1 && tempY <= M-1 && arr[tempX][tempY] == 1 && !visited[tempX][tempY]){
                    queue.add(new Pair(tempX, tempY));
                    visited[tempX][tempY] = true;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            arr[n - 1][m - 1] = 1;
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && arr[i][j] == 1){
                    count = 1;
                    bfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);
    }
}
