import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] a, d;

  static int go(int x) {
    if(d[x] != -1) return d[x];

    int num;
    if(a[x-1] == 0) num = a[x];
    else num = a[x-1]*10+a[x];

    if(1 <= num && num <= 9) {
      d[x] = go(x-1);
    }
    else if(10 <= num && num <= 26) {
      if(num%10 == 0) d[x] = go(x-2);
      else d[x] = go(x-1)+go(x-2);
    }
    else {
      if(num%10 == 0) {
        System.out.println(0);
        System.exit(0);
      }
      else {
        d[x] = go(x-1);
      }
    }
    d[x] = d[x]%1_000_000;
    return d[x];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String si = br.readLine();
    n = si.length();
    a = new int[n];
    d = new int[n];
    Arrays.fill(d, -1);

    for(int i = 0; i < n; i++) {
      a[i] = si.charAt(i)-'0';
    }

    if(a[0] == 0) {
      System.out.println(0);
      System.exit(0);
    }

    if(n == 1) {
      System.out.println(1);
      System.exit(0);
    }

    d[0] = 1;
    int num = a[0]*10+a[1];
    if(10 <= num && num <= 26) {
      if(num%10 == 0) d[1] = 1;
      else d[1] = 2;
    }
    else {
      if(num%10 == 0) {
        System.out.println(0);
        System.exit(0);
      }
      else {
        d[1] = 1;
      }
    }

    System.out.println(go(n-1));
  }
}
