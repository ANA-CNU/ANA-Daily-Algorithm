package havetostudy;

import java.io.*;
import java.util.*;

public class backjoon_13172 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long b = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long d = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            long up = (a * d % 1000000007) + (c * b % 1000000007);
            long down = b * d % 1000000007;
            a = up % 1000000007;
            b = down;
        }

        //최대공약수를 찾을까?
        long gcd;
        if (a > b)  {
            gcd = findGCD(a, b);
        }else {
            gcd = findGCD(b, a);
        }
        a /= gcd;
        b /= gcd;

        if (b == 1) {
            bw.write(a + "\n");
        }else {
            bw.write(printGiyak(a, b) + "\n");
        }
        bw.flush();
        bw.close();
    }
    static long printGiyak(long a, long b) {
        long reverseb = findreverseb(b);

        return a * reverseb % 1000000007;
    }
    static long findreverseb(long b) {
        long reverseb = b;
        long remain = 1;
        int pow = 1000000005;
        while (pow != 1) {
            if (pow % 2 == 0) {
                pow /= 2;
                reverseb = reverseb * reverseb % 1000000007;
            }else {
                remain = remain * reverseb % 1000000007;
                reverseb = reverseb * reverseb % 1000000007;
                pow /= 2;
            }
        }
        return remain * reverseb % 1000000007;
    }
    static long findGCD(long a, long b) {
        long remain = a % b;
        if (remain == 0) return b;
        return findGCD(b, remain);
    }
}

