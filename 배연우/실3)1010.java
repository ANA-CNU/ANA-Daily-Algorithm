import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] Args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            BigInteger c = factorial(m).divide(factorial(n).multiply(factorial(m-n)));
            System.out.println(c.toString());
        }
    }

    static BigInteger factorial(int m) {
        if(m <= 1) {
            return new BigInteger("1");
        }
        return factorial(m-1).multiply(new BigInteger(Integer.toString(m)));
    }
}