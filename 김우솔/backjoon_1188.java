package Mathematics;

import java.io.*;
import java.util.*;

public class backjoon_1188 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n % m == 0) {
            bw.write(0 + "\n");
        }else {
            int gcd = gcd(n, m);
            if (gcd == 1) {
                bw.write(m - 1 + "\n");
            }else {
                n /= gcd;
                m /= gcd;
                bw.write((m - 1) * gcd + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
    static int gcd(int a, int b) {
        int temp = a % b;
        if (temp == 0) return b;
        return gcd(b, temp);
    }
}