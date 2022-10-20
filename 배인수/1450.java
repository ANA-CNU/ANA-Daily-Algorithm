import java.io.*;
import java.util.*;

public class Main {

  static int n, c;
  static int[] a;
  static ArrayList<Integer> left, right;

  static void makeCombination(ArrayList<Integer> list, int start, int end, int sum) {
    if(sum > c) return;
    if(start == end) {
      list.add(sum);
      return;
    }
    makeCombination(list, start+1, end, sum);
    makeCombination(list, start+1, end, sum+a[start]);
  }

  static int rightUpperBound(int key) {
    int start = 0;
    int end = right.size();

    while(start < end) {
      int mid = (start+end)/2;
      if(right.get(mid) <= key) start = mid+1;
      else end = mid;
    }
    return end;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    a = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    left = new ArrayList<>();
    right = new ArrayList<>();
    makeCombination(left, 0, n/2, 0);
    makeCombination(right, n/2, n, 0);
    Collections.sort(right);

    long ans = 0;
    for(int i : left) {
      int idx = rightUpperBound(c-i);
      ans += idx;
    }
    System.out.println(ans);
  }
}
