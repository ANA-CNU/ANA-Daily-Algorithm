import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] Args) throws IOException {
        char[] arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        int[] cnt = new int[9];
        for (char c : arr) {
            if(c == '9') {
                cnt[6]++;
            }
            else
                cnt[c - '0']++;
        }
        cnt[6] = (cnt[6] + 1) / 2;
        int max = 0;
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, cnt[i]);
        }
        System.out.println(max);
    }
}