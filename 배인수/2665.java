import java.io.*;
import java.util.*;

class Pair {
  int x, y, cnt;

  Pair(int x, int y, int cnt) {
    this.x = x;
    this.y = y;
    this.cnt = cnt;
  }
}

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] map = new int[n][n];

    for(int i = 0; i < n; i++) {
      String si = br.readLine();
      for(int j = 0; j < n; j++) {
        map[i][j] = si.charAt(j)-'0';
      }
    }

    PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cnt));
    boolean[][] check = new boolean[n][n];
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    pq.add(new Pair(0, 0, 0));

    while(!pq.isEmpty()) {
      Pair cur = pq.poll();
      check[cur.x][cur.y] = true;

      if(cur.x == n-1 && cur.y == n-1) {
        System.out.println(cur.cnt);
        System.exit(0);
      }

      for(int i = 0; i < 4; i++) {
        int nx = cur.x+dx[i];
        int ny = cur.y+dy[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
        if(check[nx][ny]) continue;
        if(map[nx][ny] == 0) pq.add(new Pair(nx, ny, cur.cnt+1));
        else pq.add(new Pair(nx, ny, cur.cnt));
      }
    }
  }
}
