import java.io.*;
import java.util.*;

public class Main {

  static int[] left, right;

  static int lowerBound(long key) {
    int start = 0;
    int end = right.length;

    while(start < end) {
      int mid = (start+end)/2;
      if(right[mid] < key) start = mid+1;
      else end = mid;
    }
    return end;
  }

  static int upperBound(long key) {
    int start = 0;
    int end = right.length;

    while(start < end) {
      int mid = (start+end)/2;
      if(right[mid] <= key) start = mid+1;
      else end = mid;
    }
    return end;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    int[] b = new int[n];
    int[] c = new int[n];
    int[] d = new int[n];

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i] = Integer.parseInt(st.nextToken());
      b[i] = Integer.parseInt(st.nextToken());
      c[i] = Integer.parseInt(st.nextToken());
      d[i] = Integer.parseInt(st.nextToken());
    }

    left = new int[n*n];
    right = new int[n*n];

    int idx = 0;
    for(int i = 0; i < n; i++) {
      for(int j = 0; j < n; j++) {
        left[idx] = a[i]+b[j];
        right[idx] = c[i]+d[j];
        idx++;
      }
    }
    Arrays.sort(right);

    long ans = 0;
    for(long l : left) {
      ans += upperBound(-l)-lowerBound(-l);
    }
    System.out.println(ans);
  }
}
