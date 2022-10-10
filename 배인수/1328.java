import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());

    long[][][] d = new long[n+1][l+1][r+1];
    d[1][1][1] = 1;

    final long mod = 1_000_000_007L;

    for(int i = 1; i <= n-1; i++) {
      for(int j = 1; j <= l; j++) {
        for(int k = 1; k <= r; k++) {
          long temp = d[i][j][k];
          if(j+1 <= l) {
            d[i+1][j+1][k] += temp;
            d[i+1][j+1][k] %= mod;
          }
          if(k+1 <= r) {
            d[i+1][j][k+1] += temp;
            d[i+1][j][k+1] %= mod;
          }
          d[i+1][j][k] += temp*(i-1);
          d[i+1][j][k] %= mod;
        }
      }
    }

    System.out.println(d[n][l][r]);
  }
}
