import java.io.*;
import java.util.*;

public class Main {

  static char[] a;
  static int n;
  static int[][] d;

  static int go(int start, int end) {
    if(d[start][end] != -1) return d[start][end];

    if((a[start] == 'a' && a[end] == 't') || (a[start] == 'g' && a[end] == 'c')) {
      d[start][end] = Math.max(d[start][end], go(start+1, end-1)+2);
    }
    for(int i = start; i < end; i++) {
      d[start][end] = Math.max(d[start][end], go(start, i)+go(i+1, end));
    }
    return d[start][end];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    a = br.readLine().toCharArray();
    n = a.length;
    d = new int[n][n];

    for(int i = 0; i < n; i++) {
      for(int j = i; j < n; j++) {
        if(i == j) {
          d[i][j] = 0;
        }
        else if(j-i == 1) {
          if((a[i] == 'a' && a[j] == 't') || (a[i] == 'g' && a[j] == 'c')) d[i][j] = 2;
          else d[i][j] = 0;
        }
        else {
          d[i][j] = -1;
        }
      }
    }

    System.out.println(go(0, n-1));
  }
}
