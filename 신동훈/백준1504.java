
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.rangeClosed;

/**
 * Created by ShinD on 2022-03-06.
 */
@BOJ
public class 백준1504 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] distance;


    public static void main(String[] args) throws IOException {

        int[] ints = stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int numberOfVertex = ints[0];
        distance = new int[numberOfVertex+1];

        int numberOfEdges = ints[1];

        rangeClosed(0, numberOfVertex).forEach(i -> graph.add(new ArrayList<>()));

        rangeClosed(1, numberOfEdges).forEach(i ->{
            int[] inputs = stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startIndex = inputs[0];
            int targetIndex = inputs[1];
            int distance = inputs[2];
            graph.get(startIndex).add(new Node(targetIndex, distance));
            graph.get(targetIndex).add(new Node(startIndex, distance));
        });


        ints = stream(readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int firstVertex = ints[0];
        int secondVertex = ints[1];


        /**
         *
         * 다익스트라 1회
         * 시작에서 a까지 가는 거리,
         * 시작에서 b까지 가는 거리 중
         *
         * 다익스트라 2회
         * a에서 도착점까지 가는 거리,
         * a에서 b까지 가는 거리
         *
         * 다익스트라 3회
         * b에서 도착점까지 가는 거리
         *
         *
         * 결과 = {시작에서 a + b에서 도착까지 가는 값 vs 시작에서 b + a에서 도착까지 가는 값} + a-> b로 가는 값
         */
        dijkstra(1);
        if(distance[numberOfVertex] == Integer.MAX_VALUE){
            System.out.println("-1");
            return;
        }



        long startToA = distance[firstVertex];

        long startTob = distance[secondVertex];

        dijkstra(firstVertex);
        long aToGoal = distance[numberOfVertex];
        long aTob = distance[secondVertex];
        if(aTob == Integer.MAX_VALUE){
            System.out.println("-1");
            return;
        }


        dijkstra(secondVertex);
        long bToGoal = distance[numberOfVertex];

        long min = Math.min(startToA + bToGoal, startTob + aToGoal);

        System.out.println(min+aTob);





    }
    public static void dijkstra(int startIndex){
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        distance[startIndex] = 0;
        pq.add(new Node(startIndex, 0));

        while (!pq.isEmpty()){
            Node current = pq.poll();
            int currentVertex = current.getIndexOfVertex();
            int currentDistance = current.getDistance();

            if(distance[currentVertex] < currentDistance) continue;

            int size = graph.get(current.getIndexOfVertex()).size();
            for (int i = 0; i<size; i++){


                Node nextNode = graph.get(currentVertex).get(i);
                if(distance[nextNode.getIndexOfVertex()] > nextNode.getDistance() + distance[currentVertex] ){
                    distance[nextNode.getIndexOfVertex()] = nextNode.getDistance() + distance[currentVertex];
                    pq.add(new Node(nextNode.getIndexOfVertex(), distance[nextNode.getIndexOfVertex()]));
                }

            }


        }


    }



    private static String readLine(){
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class Node implements Comparable<Node>{
        private int indexOfVertex;
        private int distance;

        public Node(int indexOfVertex, int distance) {
            this.indexOfVertex = indexOfVertex;
            this.distance = distance;
        }

        public int getIndexOfVertex() {
            return indexOfVertex;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }
}
