import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int t = Integer.parseInt(br.readLine());

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n+1];
    int[] aSum = new int[n+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
      aSum[i] = aSum[i-1]+a[i];
    }

    int m = Integer.parseInt(br.readLine());
    int[] b = new int[m+1];
    int[] bSum = new int[m+1];

    st = new StringTokenizer(br.readLine());
    for(int i = 1; i <= m; i++) {
      b[i] = Integer.parseInt(st.nextToken());
      bSum[i] = bSum[i-1]+b[i];
    }

    int leftLen = n*(n+1)/2;
    int rightLen = m*(m+1)/2;

    int[] left = new int[leftLen];
    int[] right = new int[rightLen];

    int idx = 0;
    for(int i = 1; i <= n; i++) {
      for(int j = i; j <= n; j++) {
        left[idx++] = aSum[j]-aSum[i-1];
      }
    }
    idx = 0;
    for(int i = 1; i <= m; i++) {
      for(int j = i; j <= m; j++) {
        right[idx++] = bSum[j]-bSum[i-1];
      }
    }
    Arrays.sort(left);
    Arrays.sort(right);

    int leftIdx = 0;
    int rightIdx = rightLen-1;
    long ans = 0;

    while(leftIdx < leftLen && rightIdx >= 0) {
      int sum = left[leftIdx]+right[rightIdx];
      if(sum > t) rightIdx--;
      else if(sum < t) leftIdx++;
      else {
        int preLeftIdx = leftIdx;
        int preRightIdx = rightIdx;
        while(leftIdx < leftLen && left[leftIdx] == left[preLeftIdx]) leftIdx++;
        while(rightIdx >= 0 && right[rightIdx] == right[preRightIdx]) rightIdx--;
        ans += (long)(leftIdx-preLeftIdx)*(preRightIdx-rightIdx);
      }
    }

    System.out.println(ans);
  }
}
