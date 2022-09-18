import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int count = 0;

    static char arr[][]; //0,1 저장 배열
    static boolean check[][];

    static int dx[] = {0, 0, 1, -1}; //동서남북 순서
    static int dy[] = {-1, 1, 0, 0};

    static PriorityQueue<Integer> priorityQueue;

    static void DFS(int startX, int startY){ //덩어리 안에 1이 몇개인지 리턴
        check[startX][startY] = true;

        for(int i = 0; i < 4; i++){
            int tempx = startX + dx[i];
            int tempy = startY + dy[i];

            if(tempx >= 0 && tempy >= 0 && tempx <= N-1 && tempy <= N-1){
                if(arr[tempx][tempy] == '1' && !check[tempx][tempy]){
                    count++;
                    DFS(tempx, tempy);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        check = new boolean[N][N];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                arr[i][j] = temp.charAt(j);
            }
        } //input finished

        priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){ //전체배열을 돌며 탐색
            for(int j = 0; j < N; j++){
                if(arr[i][j] == '1' && !check[i][j]){
                    count = 1;
                    DFS(i, j);
                    priorityQueue.add(count);
                }
            }
        }

        int size = priorityQueue.size();
        System.out.println(size);

        for (int i = 0; i < size; i++) {
            System.out.println(priorityQueue.remove());
        }

    }
}
