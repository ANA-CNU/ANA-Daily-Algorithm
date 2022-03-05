
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by ShinD on 2022-03-04.
 */
@BOJ
public class 백준14889 {

    static int number;
    static int [][]ability ;
    static boolean [] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(br.readLine());
        visit = new boolean[number];

        ability = new int[number][number];
        for(int i =0; i< number; i++){
            ability[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        solve(0,0);
        System.out.println(min);
    }

    private static void solve(int x, int depth) {
        if(depth == number/2){
            min = Math.min(min, getDiff());
            return;
        }




        for(int i = x; i<number; i++){

            if(visit[i])continue;

            visit[i] = true;

            solve(i+1,depth+1);

            visit[i] = false;
        }
    }

    private static int getDiff() {
        int teamStart = 0;
        int teamLink = 0;


        for(int i = 0; i< number-1; i++){
            for(int j = i+1; j< number; j++){

                if(visit[i] && visit[j]){
                    teamStart += ability[i][j];
                    teamStart += ability[j][i];
                }

                if(!visit[i] && !visit[j]){
                    teamLink += ability[i][j];
                    teamLink += ability[j][i];
                }
            }
        }

        int diff = Math.abs(teamLink - teamStart);


        return diff;
    }
}
