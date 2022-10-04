import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());

    boolean[] prime = new boolean[n+1];
    Arrays.fill(prime, true);
    prime[0] = prime[1] = false;

    for(int i = 2; i*i <= n; i++) {
      if(!prime[i]) continue;
      for(int j = i*i; j <= n; j+=i) {
        prime[j] = false;
      }
    }

    ArrayList<Integer> primeList = new ArrayList<>();

    for(int i = 2; i <= n; i++) {
      if(prime[i]) {
        primeList.add(i);
      }
    }

    long[] d = new long[n+1];
    d[0] = 1;
    final long mod = 123_456_789L;

    for(int p : primeList) {
      for(int i = 1; i <= n; i++) {
        if(i >= p) {
          d[i] += d[i-p];
          d[i] %= mod;
        }
      }
    }

    System.out.println(d[n]);
  }
}
