package 그리디;

import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ShinD on 2022-03-13.
 */
@BOJ
public class 백준1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = ints[0];
        int M = ints[1];

        int pakageMin = Integer.MAX_VALUE;

        int oneMin = Integer.MAX_VALUE;


        for (int i = 0; i < M; i++) {
            int[] ints1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pakageMin = Math.min(pakageMin, ints1[0]);
            oneMin = Math.min(oneMin, ints1[1]);
        }

        int count = 0;
        pakageMin = Math.min(pakageMin, oneMin*6);


        int minMoney = 0;
        while (N >= 1){
            if(N / 6 >=1){
                minMoney+=pakageMin;
                N -=6;
            }else {

                minMoney+=Math.min(pakageMin, oneMin*N);
                break;
            }
        }
        System.out.println(minMoney);





    }
}
