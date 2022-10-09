import java.io.*;
import java.util.*;

public class Main {

  static int[] a, d;

  static int go(int x) {
    if(d[x] != -1) return d[x];
    int max = a[x];
    int min = a[x];

    for(int i = x; i >= 0; i--) {
      max = Math.max(max, a[i]);
      min = Math.min(min, a[i]);
      if(i == 0) d[x] = Math.max(d[x], max-min);
      else d[x] = Math.max(d[x], go(i-1)+max-min);
    }
    return d[x];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    a = new int[n];
    d = new int[n];
    Arrays.fill(d, -1);

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    System.out.println(go(n-1));
  }
}
