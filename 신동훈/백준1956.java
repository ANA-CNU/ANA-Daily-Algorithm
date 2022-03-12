

import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.stream.IntStream.rangeClosed;

/**
 * Created by ShinD on 2022-03-12.
 */
@BOJ
public class 백준1956 {

    private static long[][] distance;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int numOfCity;
    private static int numOfEdge ;

    static {
        int[] ints = Arrays.stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        numOfCity = ints[0];
        numOfEdge = ints[1];

        distance = new long[numOfCity+1][numOfCity+1];
        Arrays.stream(distance).forEach(longs -> Arrays.fill(longs, Integer.MAX_VALUE));

        rangeClosed(1, numOfCity).forEach(i ->{
            rangeClosed(1, numOfCity).forEach(j ->{
                if(i == j) distance[i][j] = 0;
            });
        });



        for (int i = 0; i < numOfEdge; i++) {
            ints = Arrays.stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            distance[ints[0]][ints[1]]=ints[2];
        }


    }

    private static String readLine(){
        try {
            return br.readLine();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




    public static void main(String[] args) throws IOException {
        for(int i =1; i<=numOfCity; i++){
            for(int j =1; j<=numOfCity; j++){
                for(int k =1; k<=numOfCity; k++){
                    distance[j][k] = Math.min(distance[j][i] + distance[i][k], distance[j][k]);
                }
            }
        }



        long min = Integer.MAX_VALUE;

        for (int i =1; i<= numOfCity; i++){
            for (int j =1; j<= numOfCity; j++){
                if(i == j )continue;
                min = Math.min(distance[i][j] + distance[j][i], min);
            }
        }

        if(min >= Integer.MAX_VALUE){
            System.out.println("-1");
        }else {
            System.out.println(min);
        }




    }

}
