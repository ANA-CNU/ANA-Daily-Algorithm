import java.util.*;
import java.io.*;
public class Boj2638 {
    static int n, m;
    static int[][] map;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] visited;
    static void check(){
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(map[i][j]==0){
                    dfs(i,j);
                }
            }
        }
    }
    static int day(){
        ArrayList<int[]> list = new ArrayList<>();
        int Cheese = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1) Cheese++;
                if(map[i][j]!=1) continue;
                int cnt=0;
                for(int k=0;k<4;k++){
                    int nx = i+dir[k][0];
                    int ny = j+dir[k][1];
                    if(nx<0||nx>=n||ny<0||ny>=m) continue;
                    if(map[nx][ny]==0) cnt++;
                }
                if(cnt>=2) list.add(new int[]{i,j});
            }
        }
        for(int[] cur : list){
            map[cur[0]][cur[1]] = 0;
            Cheese--;
        }
        return Cheese;
    }
    static void clear(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==-1) map[i][j] = 0;
            }
        }
    }
    static void dfs(int x,int y){
        if(visited[x][y]) return;
        boolean flag = false;
        Stack<int[]> s = new Stack<>();
        Queue<int[]> q = new LinkedList<>();
        s.push(new int[]{x,y});
        q.add(new int[]{x,y});
        visited[x][y] = true;
        while(!s.isEmpty()) {
            int[] cur = s.pop();
            if (x == 0 || x == n - 1 || y == 0 || y == m - 1) flag = true;
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dir[i][0];
                int ny = cur[1] + dir[i][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    s.push(new int[]{nx, ny});
                    q.add(new int[]{nx, ny});
                }
            }
        }
        if(!flag) {
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                map[cur[0]][cur[1]] = -1;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true){
            check();
            int Cheese = day();
            clear();
            day++;
            if(Cheese==0) break;
        }
        System.out.println(day);
    }
}
