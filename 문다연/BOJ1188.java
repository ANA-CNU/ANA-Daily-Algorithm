package BOJ;

import java.io.*;
import java.util.*;

public class BOJ1188 {

    static int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(M - GCD(N, M));
    }
}
