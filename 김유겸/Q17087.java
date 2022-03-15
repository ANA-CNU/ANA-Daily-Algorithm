package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] bro = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            bro[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }
        long answer = bro[0];
        for (int j = 1; j < N; j++) {
            answer = Math.min(answer, GCD(bro[0], bro[j]));
        }
        System.out.println(answer);
    }

    static long GCD(int num1, int num2) {
        if (num2 == 0) return num1;
        else return GCD(num2, num1 % num2);
    }
}
