import java.util.*;
import java.io.*;

class Max {
    static int N;
    static String origin[][];
    static String special[][];
    static boolean visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    public static void bfs(int x, int y, String arr[][]){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Pair temp = queue.remove();
            String current = arr[temp.x][temp.y];

            for(int i = 0; i < 4; i++){
                int tempX = temp.x + dx[i];
                int tempY = temp.y + dy[i];

                if(tempX >= 0 && tempX < N && tempY >=0 && tempY < N){
                    if(!visited[tempX][tempY] && arr[tempX][tempY].equals(current)){
                        visited[tempX][tempY] = true;
                        queue.add(new Pair(tempX, tempY));
                    }
                }
            }

        }
    }
    public static int dup(String[][] arr) {
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    bfs(i, j, arr);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        origin = new String[N][N];
        special = new String[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < N; j++) {
                String temp = String.valueOf(s.charAt(j));

                if(temp.equals("R") || temp.equals("G")){
                    origin[i][j] = temp;
                    special[i][j] = "Y";
                }else{
                    origin[i][j] = "B";
                    special[i][j] = "B";
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dup(origin)).append(" ");

        visited = new boolean[N][N];
        sb.append(dup(special));

        System.out.println(sb);
    }
}
class Pair{
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
