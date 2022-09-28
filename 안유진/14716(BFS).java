import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

public class Horororo {
    static int w;
    static int h;
    static int count;
    static int arr[][];
    static boolean visited[][];

    static int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void bfs(int x, int y){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Pair p = queue.remove();
            int tempx = p.getX();
            int tempy = p.getY();

            visited[tempx][tempy] = true;

            for(int i = 0; i < 8; i++){
                int nextX = tempx + dx[i];
                int nextY = tempy + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX <= w - 1  && nextY <= h - 1 && arr[nextX][nextY] == 1){
                    if(visited[nextX][nextY]){
                        continue;
                    }
                    visited[nextX][nextY] = true;
                    queue.add(new Pair(nextX, nextY));
                }
            }
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        count = 0;

        arr = new int[w][h];
        visited = new boolean[w][h];

        for(int i = 0; i < w; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < h; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0){
                    visited[i][j] = true;
                }
            }
        } //배열에 입력

        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++){
                if(visited[i][j]){
                    continue;
                }else{
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
