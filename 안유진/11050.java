import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hororop {
    static int cal(int n, int k){
        int sum = 1;
        for(int i = 1; i<n+1; i++){
            sum *= i;
        }
        int deno = 1;
        for(int i = 1; i<n-k+1; i++){
            deno *= i;
        }
        int kpac = 1;
        for(int i = 1; i<k+1; i++){
            kpac *= i;
        }
        return sum / (deno * kpac);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(cal(N, K));
    }
}
