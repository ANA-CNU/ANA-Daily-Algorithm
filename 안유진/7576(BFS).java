import java.util.*;
import java.io.*;

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

public class Meow {
    static int M;
    static int N;
    static int box[][];
    static boolean check[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    static Queue<Pair> queue;

    static void BFS(){
        while (!queue.isEmpty()){

            Pair p = queue.remove();
            check[p.getX()][p.getY()] = true;

            for(int i = 0; i < 4; i++){
                int tempX = p.getX() + dx[i];
                int tempY = p.getY() + dy[i];

                if(tempX >= 0 && tempY >= 0 && tempX <= N-1 && tempY <= M-1 && box[tempX][tempY] == 0 && !check[tempX][tempY]){
                    box[tempX][tempY] = box[p.getX()][p.getY()] + 1;
                    queue.add(new Pair(tempX, tempY));
                    check[tempX][tempY] = true;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken()); //열
        N = Integer.parseInt(st.nextToken()); //행

        box = new int[N][M];
        check = new boolean[N][M];
        queue = new LinkedList<>();

        boolean flag = false;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0; j < M; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    queue.add(new Pair(i, j));
                }else{
                    flag = true;
                }
            }
        }

        BFS();

        int max = Integer.MIN_VALUE;
        boolean zeroCheck = false;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
               if(box[i][j] == 0){
                   zeroCheck = true;
               }
               max = Math.max(max, box[i][j]);
            }
        }

        if(!flag){
            System.out.println(0);
        }else if(zeroCheck){
            System.out.println(-1);
        }else{
            System.out.println(max - 1);
        }
    }
}
//토마토가 층별로 있음
//위 아래 왼 오 앞 뒤
