package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2089 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if(N == 0) sb.append(0);
        while(N!=0) {
            sb.append(Math.abs(N%-2));
            N=(int)Math.ceil((double)N/-2);
        }
        System.out.println(sb.reverse());
    }
}
