import java.util.*;
import java.io.*;

class Tuple{
    private final int x;
    private final int y;
    private final int h;
    Tuple(int h, int x, int y){
        this.h = h;
        this.x = x;
        this.y = y;
    }
    public int getH(){
        return h;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}

public class Main {
    static int M; //가로
    static int N; //세로
    static int H; //높이

    static int box[][][];
    static boolean check[][][];
    static Queue<Tuple> queue;

    static int dh[] = {-1, 1}; //h
    static int dx[] = {0, 0, -1, 1}; //i
    static int dy[] = {-1, 1, 0, 0}; //j

    static public void bfs(){
        while (!queue.isEmpty()){
            Tuple t = queue.remove();
            check[t.getH()][t.getX()][t.getY()] = true;

            for(int i = 0; i < 2; i++){
                int tempH = t.getH() + dh[i];
                int tempX = t.getX();
                int tempY = t.getY();
                if(tempH >= 0 && tempH <= H - 1){
                    if(box[tempH][tempX][tempY] == 0 && !check[tempH][tempX][tempY]){
                        //범위안에 있고 탐색하지 않았으면
                        check[tempH][tempX][tempY] = true;
                        box[tempH][tempX][tempY] = box[t.getH()][tempX][tempY] + 1;
                        queue.add(new Tuple(tempH, tempX, tempY));
                    }
                }
            }
            for(int i = 0; i < 4; i++){
                int tempH = t.getH();
                int tempX = t.getX() + dx[i];
                int tempY = t.getY() + dy[i];
                if(tempX >= 0 && tempY >= 0 && tempX <= N-1 && tempY <= M-1){
                    if(box[tempH][tempX][tempY] == 0 && !check[tempH][tempX][tempY]){
                        check[tempH][tempX][tempY] = true;
                        box[tempH][tempX][tempY] = box[tempH][t.getX()][t.getY()] + 1;
                        queue.add(new Tuple(tempH, tempX, tempY));
                    }
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        M = Integer.parseInt(st.nextToken()); // j
        N = Integer.parseInt(st.nextToken()); // i
        H = Integer.parseInt(st.nextToken()); // h

        box = new int[H][N][M];
        check = new boolean[H][N][M];
        boolean flag = false; //토마토가 다 익어있는지 확인
        queue = new LinkedList<>();

        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j = 0; j < M; j++){
                    box[h][i][j] = Integer.parseInt(st.nextToken());
                    if(box[h][i][j] == 0){
                        flag = true;
                    }
                    if(box[h][i][j] == 1){
                        queue.add(new Tuple(h, i, j)); //익은 토마토 추가
                    }
                }
            }
        } //input finish

        bfs();

        boolean checkZero = false;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                for(int x = 0; x < M; x++){
                    max = Math.max(max, box[i][j][x]);
                    if(box[i][j][x] == 0){
                        checkZero = true;
                    }
                }
            }
        }

        if(checkZero){
            System.out.println(-1);
        }else if(!flag){
            System.out.println(0);
        }else{
            System.out.println(max - 1);
        }

    }
}
//토마토가 층별로 있음
//위 아래 왼 오 앞 뒤
