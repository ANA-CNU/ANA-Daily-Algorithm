import java.io.*;
import java.util.*;

public class Main {

  static long[][] d;

  static long go(int full, int half) {
    if(d[full][half] != -1) return d[full][half];

    if(half == 0) d[full][half] = go(full-1, 1);
    else d[full][half] = go(full-1, half+1)+go(full, half-1);
    return d[full][half];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    d = new long[31][31];
    for(int i = 0; i <= 30; i++) {
      for(int j = 0; j <= 30; j++) {
        if(i == 0) d[i][j] = 1;
        else d[i][j] = -1;
      }
    }

    String s = "";
    while(!(s = br.readLine()).equals("0")) {
      int n = Integer.parseInt(s);
      sb.append(go(n, 0)).append('\n');
    }
    System.out.println(sb);
  }
}
