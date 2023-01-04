import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean arr[] = new boolean[10001];

        arr[0] = true;
        arr[1] = true;

        for(int i = 2; i * i < 10001; i++) {
            if(!arr[i]) {
                for(int j = i * i; j < 10001; j+=i) {
                    arr[j] = true;
                }
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            int n = Integer.parseInt(br.readLine());

            int half = (n / 2);

            while (half != n) {
                if(!arr[half]) {
                    if(!arr[n - half]){
                        sb.append(n - half).append(" ").append(half).append('\n');
                        break;
                    }
                }
                half++;
            }
        }

        System.out.println(sb);
    }
}

