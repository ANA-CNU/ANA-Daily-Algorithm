import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(st.nextToken());
                for(int j = 2; j <= num; j++){
                    if(num == j) cnt++;
                    if(num % j == 0) break;

                }
        }

        System.out.println(cnt);
    }

}
