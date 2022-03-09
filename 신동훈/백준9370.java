import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/**
 * Created by ShinD on 2022-03-08.
 */
@BOJ
public class 백준9370 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    private static int[] distance;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int testCase = Integer.parseInt(readLine());

        IntStream.range(0, testCase).forEach(i-> solve());

        System.out.println(sb.toString());
    }



    public static void solve(){
        /**
         * numberVertex : 교차로,
         * numberOfLoad : 도로,
         * numberOfDestinationCandidate : 목적지 후보의 개수이다.
         */
        int[] ints = Arrays.stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int numberVertex = ints[0];
        int numberOfLoad = ints[1];
        int numberOfDestinationCandidate = ints[2];

        /**
         * fill Distance Array by INF
         */
        distance = new int[numberVertex + 1];


        /**
         * startVertex : 예술가들의 출발지이고,
         * crossVertex1, crossVertex2 : 지나간 도로
         */
        ints = Arrays.stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int startVertex = ints[0];
        int crossVertex1 = ints[1];
        int crossVertex2 = ints[2];


        /**
         * refresh graph( that has info of Vertex and Load)
         */
        graph = new ArrayList<>();
        IntStream.rangeClosed(0,numberVertex).forEach(i -> graph.add(new ArrayList<>()));


        /**
         * set graph
         */
        IntStream.range(0,numberOfLoad).forEach(i -> {
            int[] ints1 = Arrays.stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(ints1[0]).add(new Node(ints1[1], ints1[2]));
            graph.get(ints1[1]).add(new Node(ints1[0], ints1[2]));
        });


        /**
         * set DestinationCandidate in array
         */
        int [] candidate = new int[numberOfDestinationCandidate];
        IntStream.range(0,numberOfDestinationCandidate).forEach(i -> candidate[i] = Integer.parseInt(readLine()));
        Arrays.sort(candidate);


        /**
         * s(출발점) -> g    + h -> 도착지 사의의 거리들 중 가장 작은 값,   g와 h 사이의 거리는 안 구해도 돼!
         * s(출발점) -> h    + g -> 도착지 사의의 거리들 중 가장 작은 값,
         *
         *
         * s -> g   + g -> h  +  h -> 도착지 = s -> 도착지
         * s -> h   + h -> g  +  g -> 도착지 = s -> 도착지
         */

        long [] startToGoalDistance = new long[numberVertex+1];
        long [] gToGoalDistance = new long[numberVertex+1];
        long [] hToGoalDistance = new long[numberVertex+1];



        dijkstra(startVertex);
        for (int i = 0; i < numberOfDestinationCandidate; i++) {//시작 -> 목적지
            startToGoalDistance[candidate[i]] = distance[candidate[i]];
        }
        long sToG = distance[crossVertex1];//s to g
        long sToH = distance[crossVertex2];//s to h



        dijkstra(crossVertex1);//g to 목적지
        for (int i = 0; i < numberOfDestinationCandidate; i++) {//시작 -> 목적지
            gToGoalDistance[candidate[i]] = distance[candidate[i]];
        }
        long gToH = distance[crossVertex2];




        dijkstra(crossVertex2);//h to 목적지
        for (int i = 0; i < numberOfDestinationCandidate; i++) {//시작 -> 목적지
            hToGoalDistance[candidate[i]] = distance[candidate[i]];
        }
        long hToG = distance[crossVertex1];





        for (int i = 0; i < numberOfDestinationCandidate; i++) {//시작 -> 목적지
            if(startToGoalDistance[candidate[i]] == sToG + gToH + hToGoalDistance[candidate[i]]){
                sb.append(candidate[i]).append(" ");
            }else if(startToGoalDistance[candidate[i]] == sToH + hToG + gToGoalDistance[candidate[i]]){
                sb.append(candidate[i]).append(" ");
            }
        }
        sb.append("\n");


    }

    private static void dijkstra(int startVertex) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        /**
         * set startVertex's distance 0
         */
        distance[startVertex] = 0;
        pq.add(new Node(startVertex, 0));


        while (!pq.isEmpty()){
            Node current = pq.poll();
            int nIndex = current.index();
            int nDistance = current.distance();

            /**
                if already confirm min distance, continue
             */
            if(distance[nIndex] < nDistance) continue;


            IntStream.range(0, graph.get(nIndex).size()).forEach(i -> {
                Node nextVertex = graph.get(nIndex).get(i);
                if(nDistance +nextVertex.distance() < distance[nextVertex.index()]){
                    distance[nextVertex.index()] = nDistance +nextVertex.distance();
                    pq.add(new Node(nextVertex.index(), distance[nextVertex.index()]));
                }

            });

        }

    }


    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class Node implements Comparable<Node>{
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int index() {
            return index;
        }

        public int distance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }
}
