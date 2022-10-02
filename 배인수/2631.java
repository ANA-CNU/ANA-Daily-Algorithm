import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    int[] d = new int[n];

    for(int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(br.readLine());
    }

    int dMax = 0;

    for(int i = 0; i < n; i++) {
      d[i] = 1;
      for(int j = 0; j < i; j++) {
        if(a[j] < a[i]) {
          d[i] = Math.max(d[i], d[j]+1);
        }
      }
      dMax = Math.max(dMax, d[i]);
    }

    System.out.println(n-dMax);
  }
}
