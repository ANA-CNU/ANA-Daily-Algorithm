import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int a = 1;
        int b = factorial(k);

        for (int i = 0; i < k; i++) {
            a *= n;
            n--;
        }
        int result = a / b;

        bw.write(result + "");
        bw.close();
    }

    static int factorial (int a) {
        if (a == 1 || a == 0)
            return 1;
        return a * factorial(a - 1);
    }
}
