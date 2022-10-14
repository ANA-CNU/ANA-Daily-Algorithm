import java.io.*;
import java.util.*;

public class Main {

  static int[] d;
  static int dLen;

  static int lowerBound(int key) {
    int start = 0;
    int end = dLen;

    while(start < end) {
      int mid = (start+end)/2;
      if(d[mid] < key) start = mid+1;
      else end = mid;
    }
    return end;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    d = new int[n];
    dLen = 0;

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    for(int i = 0; i < n; i++) {
      int idx = lowerBound(a[i]);
      d[idx] = a[i];
      if(idx == dLen) dLen++;
    }
    System.out.println(n-dLen);
  }
}
