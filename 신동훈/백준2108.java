
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by ShinD on 2022-03-09.
 */
@BOJ
public class 백준2108 {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Integer, Integer> map= new HashMap<>();


    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        long sum = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(readLine());
            sum+=input;
            list.add(input);

            if(map.containsKey(input)){
                map.put(input, map.get(input)+1);
            }else {
                map.put(input, 1);
            }
        }


        sb.append(Math.round((sum*1.0)/n)).append("\n");

        list.sort(Comparator.naturalOrder());
        sb.append(list.get(n/2)).append("\n");

        List<Integer> maxNumbers = new ArrayList<>();
        int maxCount = 0;
        for (Integer i : map.keySet()) {
            if(maxCount < map.get(i)){

                maxCount=map.get(i);
                maxNumbers.clear();
                maxNumbers.add(i);
            }else if(maxCount == map.get(i)){
                maxNumbers.add(i);
            }
        }



        maxNumbers.sort(Comparator.naturalOrder());
        if(maxNumbers.size()==1){
            sb.append(maxNumbers.get(0)).append("\n");
        }else {
            sb.append(maxNumbers.get(1)).append("\n");
        }

        sb.append(list.get(n-1) - list.get(0));
        System.out.println(sb.toString());


    }

    public static String readLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
