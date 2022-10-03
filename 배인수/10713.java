import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] p = new int[m+1];
    long[] a = new long[n];
    long[] b = new long[n];
    long[] c = new long[n];
    int[] cnt = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= m; i++) {
      p[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 1; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i] = Long.parseLong(st.nextToken());
      b[i] = Long.parseLong(st.nextToken());
      c[i] = Long.parseLong(st.nextToken());
    }

    for(int i = 1; i < m; i++) {
      int from = Math.min(p[i], p[i+1]);
      int to = Math.max(p[i], p[i+1]);
      for(int j = from; j < to; j++) {
        cnt[j]++;
      }
    }

    long ans = 0;
    for(int i = 1; i < n; i++) {
      ans += Math.min(a[i]*cnt[i], b[i]*cnt[i]+c[i]);
    }
    System.out.println(ans);
  }
}
