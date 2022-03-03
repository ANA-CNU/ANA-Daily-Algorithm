
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by ShinD on 2022-03-02.
 */
@BOJ
public class 백준9663 {
    private static int queenCount;
    private static int[] map;
    private static int result =0;

    static {

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            queenCount =Integer.parseInt(br.readLine());
            map=new int[queenCount];
            Arrays.fill(map, -1);

        }
        catch (IOException e){}
    }


    public static void main(String[] args) throws IOException {
        backTracking(0);
        System.out.println(result);

    }

    public static void backTracking( int depth){
        /**
         * 먼저 0,0 ~~~ N-1, N-1 까지 하나씩 돌아야 해
         *
         * 하나를 설치 -> isBatchable 설정 & 설치 count(depth) 증가
         *
         * 만약 depth == queenCount라면  경우의 수 증가
         *
         *
         *
         */

        if(depth == queenCount){
            result++;
            return;
        }

        for(int x=0; x<queenCount; x++){
            /**
             * 만약 map[ny][i] 에 배치가 가능하다면
             * map[ny][i] = 1;//1은 Queen, 0은 빈칸
             * setBatchable();
             * backTracking(nx+1,ny+1,depth+1);
             */
            map[depth] = x;//depth는 행, x는 열  (x, depth)에 놓은 것

            if(isBatchable(x, depth)){
                backTracking(depth+1);
            }
        }



    }

    public static boolean isBatchable(final int x, final int y) {
        /**
         * 만약 x가 같은 값이 하나라도 존재한다면? false,
         *
         * 대각선은, 인덱스(y)의 차이와, 인덱스번째의 값(x)의 차이가 동일한 경우
         */




        for(int i =0; i< y; i++){
            if(map[y] == map[i]){
                return false;
            }

            if(Math.abs(i - y)  == Math.abs(map[i] - map[y])){
                return false;
            }
        }
        return true;

    }




}
