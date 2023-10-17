import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[N];
        int[] sum = new int[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);
        sum[0] = time [0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + time[i];
        }
        for (int i = 0; i < N; i++) {
            result += sum[i];
        }
        System.out.println(result);
    }
}
