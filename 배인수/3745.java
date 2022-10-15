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

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    while(sc.hasNextLine()) {
      int n = Integer.parseInt(sc.nextLine().trim());
      int[] a = new int[n];

      st = new StringTokenizer(sc.nextLine());
      for(int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(st.nextToken());
      }

      d = new int[n];
      dLen = 0;

      for(int i = 0; i < n; i++) {
        int idx = lowerBound(a[i]);
        d[idx] = a[i];
        if(idx == dLen) dLen++;
      }

      sb.append(dLen).append('\n');
    }

    System.out.println(sb);
  }
}
