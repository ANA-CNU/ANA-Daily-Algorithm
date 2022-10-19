import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    String si = br.readLine();
    int len = si.length();

    char[] a = new char[len+1];
    int[] alpha = new int[26];

    for(int i = 1; i <= len; i++) {
      a[i] = si.charAt(i-1);
    }

    int ans = 0;
    int cnt = 1;
    alpha[a[1]-'a']++;

    for(int start = 1, end = 1; end <= len;) {
      if(cnt <= n) ans = Math.max(ans, end-start+1);

      if(cnt > n) {
        if(alpha[a[start]-'a'] == 1) cnt--;
        alpha[a[start]-'a']--;
        start++;
      }
      else {
        if(end+1 <= len) {
          if(alpha[a[end+1]-'a'] == 0) cnt++;
          alpha[a[end+1]-'a']++;
        }
        end++;
      }
    }

    System.out.println(ans);
  }
}
