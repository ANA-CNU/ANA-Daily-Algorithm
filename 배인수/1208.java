import java.io.*;
import java.util.*;

public class Main {

  static int[] a;
  static ArrayList<Integer> left, right;

  static void makeComb(ArrayList<Integer> list, int start, int end, int sum) {
    if(start == end) {
      list.add(sum);
      return;
    }
    makeComb(list, start+1, end, sum);
    makeComb(list, start+1, end, sum+a[start]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int s = Integer.parseInt(st.nextToken());
    a = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }

    left = new ArrayList<>();
    right = new ArrayList<>();
    makeComb(left, 0, n/2, 0);
    makeComb(right, n/2, n, 0);
    Collections.sort(left);
    Collections.sort(right);

    long ans = 0;
    int leftIdx = 0;
    int rightIdx = right.size()-1;

    while(leftIdx <= left.size()-1 && rightIdx >= 0) {
      int sum = left.get(leftIdx)+right.get(rightIdx);
      if(sum > s) rightIdx--;
      else if(sum < s) leftIdx++;
      else {
        int preLeftIdx = leftIdx;
        int preRightIdx = rightIdx;
        while(true) {
          if(leftIdx >= left.size()) break;
          if(!left.get(leftIdx).equals(left.get(preLeftIdx))) break;
          leftIdx++;
        }
        while(true) {
          if(rightIdx < 0) break;
          if(!right.get(rightIdx).equals(right.get(preRightIdx))) break;
          rightIdx--;
        }
        ans += (long)(leftIdx-preLeftIdx)*(preRightIdx-rightIdx);
      }
    }

    if(s == 0) {
      if(ans != 0) ans--;
    }
    System.out.println(ans);
  }
}
