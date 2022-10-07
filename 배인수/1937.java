import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[][] map, d;
  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};

  static int go(int x, int y) {
    if(d[x][y] != -1) return d[x][y];

    for(int i = 0; i < 4; i++) {
      int nx = x+dx[i];
      int ny = y+dy[i];
      if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
      if(map[nx][ny] < map[x][y]) {
        d[x][y] = Math.max(d[x][y], go(nx, ny)+1);
      }
    }

    if(d[x][y] == -1) d[x][y] = 1;
    return d[x][y];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    n = Integer.parseInt(br.readLine());
    map = new int[n][n];
    d = new int[n][n];
    for(int i = 0; i < n; i++) {
      Arrays.fill(d[i], -1);
    }

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < n; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    int ans = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        ans = Math.max(ans, go(i, j));
      }
    }
    System.out.println(ans);
  }
}
