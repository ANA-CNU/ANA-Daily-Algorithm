import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_11050 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");

        int N = Integer.parseInt(st[0]);
        int K = Integer.parseInt(st[1]);

        System.out.println(factorial(N)/(factorial(N-K) * factorial(K)));

    }
    public static int factorial(int n){
        int result = 1;
        for(int i = 1; i <= n; i++){
            result *= i;
        }
        return result;
    }
}
