import java.io.*;
import java.util.*;

public class Main {

  static int[] d;
  static int dLen;

  static int lowerBound(int key) {
    int start = 0;
    int end = dLen;

    while(start < end) {
      int mid =(start+end)/2;
      if(d[mid] < key) start = mid+1;
      else end = mid;
    }
    return end;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int n = Integer.parseInt(br.readLine());
    int[][] a = new int[n][2]; //[][0: 왼쪽 연결 번호, 1: 오른쪽 연결 번호]
    int[] idxCheck = new int[n]; //lis 수열의 몇번째 인덱스인지
    d = new int[n];
    dLen = 0;

    for(int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      a[i][0] = Integer.parseInt(st.nextToken());
      a[i][1] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(a, Comparator.comparingInt(o -> o[0]));

    for(int i = 0; i < n; i++) {
      int idx = lowerBound(a[i][1]);
      d[idx] = a[i][1];
      idxCheck[i] = idx;
      if(idx == dLen) dLen++;
    }

    ArrayList<Integer> lisList = new ArrayList<>();
    boolean[] check = new boolean[500_001];

    int temp = dLen-1;
    for(int i = n-1; i >= 0; i--) {
      if(idxCheck[i] == temp) {
        lisList.add(a[i][0]);
        temp--;
      }
    }

    for(int i : lisList) {
      check[i] = true;
    }

    sb.append(n-dLen).append('\n');
    for(int i = 0; i < n; i++) {
      if(check[a[i][0]]) continue;
      sb.append(a[i][0]).append('\n');
    }
    System.out.println(sb);
  }
}

/*
4
1 2
2 3
3 4
4 1
 */
