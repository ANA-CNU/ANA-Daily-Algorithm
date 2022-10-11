import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    int[] a = new int[n+1];
    int[][] dist = new int[n+1][n+1];
    for(int i = 1; i <= n; i++) {
      for(int j = 1; j <= n; j++) {
        if(i == j) continue;
        dist[i][j] = 10000;
      }
    }

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < r; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      int l = Integer.parseInt(st.nextToken());
      dist[x][y] = dist[y][x] = l;
    }

    for(int k = 1; k <= n; k++) {
      for(int i = 1; i <= n; i++) {
        for(int j = 1; j <= n; j++) {
          if(dist[i][j] > dist[i][k]+dist[k][j]) {
            dist[i][j] = dist[i][k]+dist[k][j];
          }
        }
      }
    }

    int ans = 0;
    for(int i = 1; i <= n; i++) {
      int sum = 0;
      for(int j = 1; j <= n; j++) {
        if(dist[i][j] <= m) {
          sum += a[j];
        }
      }
      ans = Math.max(ans, sum);
    }

    System.out.println(ans);
  }
}
