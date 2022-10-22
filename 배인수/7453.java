import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    long[] a = new long[n];
    long[] b = new long[n];
    long[] c = new long[n];
    long[] d = new long[n];

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i] = Long.parseLong(st.nextToken());
      b[i] = Long.parseLong(st.nextToken());
      c[i] = Long.parseLong(st.nextToken());
      d[i] = Long.parseLong(st.nextToken());
    }

    long[] left = new long[n*n];
    long[] right = new long[n*n];

    int idx = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        left[idx] = a[i]+b[j];
        right[idx] = c[i]+d[j];
        idx++;
      }
    }
    Arrays.sort(left);
    Arrays.sort(right);

    long ans = 0;
    int leftIdx = 0;
    int rightIdx = right.length-1;

    while(leftIdx <= left.length-1 && rightIdx >= 0) {
      long sum = left[leftIdx]+right[rightIdx];
      if(sum > 0) rightIdx--;
      else if(sum < 0) leftIdx++;
      else {
        int preLeftIdx = leftIdx;
        int preRightIdx = rightIdx;

        while(leftIdx <= left.length-1 &&
            left[leftIdx] == left[preLeftIdx]) leftIdx++;
        while(rightIdx >= 0 &&
            right[rightIdx] == right[preRightIdx]) rightIdx--;

        ans += (long)(leftIdx-preLeftIdx)*(preRightIdx-rightIdx);
      }
    }

    System.out.println(ans);
  }
}
