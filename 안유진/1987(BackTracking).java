import java.util.*;
import java.io.*;

class Main {
    static int R,C;
    static int arr[][];
    static boolean visited[][];
    static HashMap<Integer, Boolean> hashMap = new HashMap<>();

    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    static int max = -1;
    static int count = 0;
    public static void dfs(int x, int y) {
        visited[x][y] = true;
        hashMap.put(arr[x][y], true);
        count++;
        for(int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX < R && nextX >= 0 && nextY < C && nextY >= 0){
                if(!visited[nextX][nextY] && !hashMap.get(arr[nextX][nextY])) {
                    dfs(nextX, nextY);
                }
            }
        }
        if(count > max) {
            max = count;
        }
        hashMap.put(arr[x][y], false);
        visited[x][y] = false;
        count--;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 65; i < 91; i++) {
            hashMap.put(i, false);
        }

        for(int i = 0; i < R; i++) {
            String s = br.readLine();
            for(int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }
}
