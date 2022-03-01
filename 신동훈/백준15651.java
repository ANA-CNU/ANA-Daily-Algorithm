

import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ShinD on 2022-03-01.
 */
@BOJ
public class 백준15651 {


    private static StringBuilder sb = new StringBuilder();
    private static int MAX_INTEGER;
    private static int SIZE;
    private static List<Integer> list = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] intArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        MAX_INTEGER = intArr[0];
        SIZE = intArr[1];

        dfs(1,0);
        System.out.println(sb.toString());
    }



    private static void dfs(int nowInteger, int depth) {
        if(depth == SIZE){
            list.forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }


        for(int i = 1; i<= MAX_INTEGER; i++){
            list.add(depth, i);
            dfs(i, depth+1);
            list.remove(depth);
        }

    }


}
