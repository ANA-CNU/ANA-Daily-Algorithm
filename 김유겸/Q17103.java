package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int maxIndex = 1000000;
        int[] prime = new int[maxIndex + 1];
        //prime배열의 인덱스 값이 0이면 소수

        prime[1] = 1;//1은 소수 X
        for (int i = 2; i <= Math.sqrt(maxIndex); i++) {
            if (prime[i] == 0) {
                for (int j = i * 2; j <= maxIndex; j += i) {
                    prime[j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 1; j <= N/2; j++) {
                if(prime[j] == 0 && prime[N-j] == 0){
                        count ++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
