import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int tc = Integer.parseInt(br.readLine());
    while(tc-- > 0) {
      st = new StringTokenizer(br.readLine());
      int k = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());
      int[][] a = new int[4][n];

      for(int i = 0; i < 4; i++) {
        st = new StringTokenizer(br.readLine());
        for(int j = 0; j < n; j++) {
          a[i][j]  =Integer.parseInt(st.nextToken());
        }
      }

      int[] left = new int[n*n];
      int[] right = new int[n*n];

      int idx = 0;
      for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
          left[idx] = a[0][i]+a[1][j];
          right[idx] = a[2][i]+a[3][j];
          idx++;
        }
      }
      Arrays.sort(left);
      Arrays.sort(right);

      int leftIdx = 0;
      int rightIdx = n*n-1;
      int ans = -1_000_000_000;

      while(leftIdx <= n*n-1 && rightIdx >= 0) {
        int sum = left[leftIdx]+right[rightIdx];

        if(Math.abs(sum-k) < Math.abs(ans-k)) ans = sum;
        else if(Math.abs(sum-k) == Math.abs(ans-k) && sum < ans) ans = sum;

        if(sum > k) rightIdx--;
        else if(sum < k) leftIdx++;
        else {
          ans = k;
          break;
        }
      }

      sb.append(ans).append('\n');
    }

    System.out.println(sb);
  }
}
