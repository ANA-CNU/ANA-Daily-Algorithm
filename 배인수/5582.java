import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    char[] a = br.readLine().toCharArray();
    char[] b = br.readLine().toCharArray();
    int[][] d = new int[a.length+1][b.length+1];

    int ans = 0;

    for(int i = 1; i <= a.length; i++) {
      for(int j = 1; j <= b.length; j++) {
        if(a[i-1] == b[j-1]) {
          d[i][j] = d[i-1][j-1]+1;
          ans = Math.max(ans, d[i][j]);
        }
      }
    }

    System.out.println(ans);
  }
}
