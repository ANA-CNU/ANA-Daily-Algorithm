
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

/**
 * Created by ShinD on 2022-03-10.
 */
@BOJ
public class 백준11404 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long[][] distance;

    public static void main(String[] args) throws IOException {


        int numOfCity = Integer.parseInt(br.readLine());

        setCityDistance(numOfCity);

        fillMapByMaxInt();

        fillSelfByZero(numOfCity);

        int numOfBus = Integer.parseInt(br.readLine());

        setDefaultDistanceByInput(numOfBus);

        floydWarshall(numOfCity);

        StringBuilder sb = getPrintStr(numOfCity);

        System.out.println(sb.toString());


    }


    private static StringBuilder getPrintStr(int numOfCity) {
        StringBuilder sb = new StringBuilder();
        rangeClosed(1, numOfCity).forEach(i -> {
            rangeClosed(1, numOfCity).forEach(j -> {
                if(distance[i][j] >= Integer.MAX_VALUE) sb.append("0 ");

                else sb.append(distance[i][j]+" ");
            });
            sb.append("\n");
        });
        return sb;
    }


    private static void setDefaultDistanceByInput(int numOfBus) {
        IntStream.range(0, numOfBus).forEach(i -> {
            List<Integer> busInfos = Arrays.stream(readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            distance[busInfos.get(0)][busInfos.get(1)] = Math.min( distance[busInfos.get(0)][busInfos.get(1)], busInfos.get(2));
        });
    }

    private static void fillSelfByZero(int numOfCity) {
        rangeClosed(1, numOfCity).forEach(i ->{
            rangeClosed(1, numOfCity).forEach(j ->{
                if(i == j) distance[i][j] = 0;
            });
        });
    }

    private static void fillMapByMaxInt() {
        Arrays.stream(distance).forEach(ints -> Arrays.fill(ints, Integer.MAX_VALUE));
    }

    private static void setCityDistance(int numOfCity) {
        distance = new long[numOfCity +1][numOfCity +1];
    }

    private static void floydWarshall(int numOfCity) {
        for(int i =1; i<=numOfCity; i++ ){
            for(int j =1; j<=numOfCity; j++ ){
                for(int k =1; k<=numOfCity; k++ ){
                    distance[j][k] = Math.min(distance[j][k], distance[j][i] + distance[i][k]);
                }
            }
        }


    }


    public static String  readLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
