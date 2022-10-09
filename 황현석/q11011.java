import java.io.*;
import java.util.*;

public class Main {
  public static int N, K;
  public static long[] dp, a, b;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    
    a = new long[N];
    b = new long[N];
    dp = new long[N];
    st = new StringTokenizer(br.readLine());
    for (int i=0;i<N;i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    
    st = new StringTokenizer(br.readLine());
    for (int i=0;i<N;i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
    
    dnc(0, N-1, 0, N-1);
    System.out.println(answer);
  }
  public static long answer;
  
  public static void dnc (int l, int r, int dl, int dr) {
    int mid = l + r >> 1;
    int idx = -1;
    long value = -1;
    
    for (int i=Math.max(dl,mid-K);i<=mid&&i<=dr;i++) {
      if (value < (mid - i) * a[mid] + b[i]) {
        value = (mid - i) * a[mid] + b[i];
        idx = i;
      }
    }
    answer = Math.max(answer, value);
    
    if (l == r) return;
    
    dnc(l, mid, dl, idx);
    dnc(mid+1, r, idx, dr);
  }
  
}
