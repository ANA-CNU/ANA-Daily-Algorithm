package 백트래킹;

import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ShinD on 2022-03-02.
 */

@BOJ
public class 백준15652 {
    private static int MAX_INTEGER;
    private static int SIZE;
    private static List<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        MAX_INTEGER = ints[0];
        SIZE = ints[1];
        backTracking(1,0);
        System.out.println(sb.toString());

    }

    public static void backTracking(int nowInt, int depth){
        if(depth == SIZE){
            list.forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }


        for(int i = 1; i<= MAX_INTEGER; i++){
            if( depth != 0 && i < list.get(depth-1)) continue;
            list.add(depth, i);
            backTracking(nowInt+1, depth+1);
            list.remove(depth);
        }

    }
}
