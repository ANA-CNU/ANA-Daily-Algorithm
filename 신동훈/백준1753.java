
import annotation.boj.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

import static java.util.stream.IntStream.rangeClosed;

/**
 * Created by ShinD on 2022-03-05.
 */

@BOJ
public class 백준1753 {

    private static int numberOfVertices;
    private static int numberOfEdges;

    private static int[] distance;
    private static ArrayList<ArrayList<Node>> graph = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        numberOfVertices = ints[0];
        numberOfEdges = ints[1];


        rangeClosed(0, 300001).forEach(i -> graph.add(new ArrayList<>()));//간선의 개수만큼 생성


        int startPoint = Integer.parseInt(br.readLine());

        distance = new int[20001];



        for (int i = 0; i < numberOfEdges; i++) {
            ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(ints[0]).add(new Node(ints[1], ints[2]));
        }

        Arrays.fill(distance, Integer.MAX_VALUE);//거리 모두 최대로 설정


        dijkstra(startPoint);

        StringBuilder sb =new StringBuilder();
        rangeClosed(1, numberOfVertices).forEach(i -> {
            if(distance[i] == Integer.MAX_VALUE){
                sb.append("INF\n");
            }else {
                sb.append(distance[i]).append("\n");
            }

        });

        System.out.println(sb.toString());






    }

    public static void dijkstra(int startingPoint){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        /**
         * 시작점 거리 0으로 초기화
         */
        distance[startingPoint] = 0;
        pq.add(new Node(startingPoint, 0));//시작점으로 도착하는 최소거리는 0이다.


        while (!pq.isEmpty()){
            Node current = pq.poll();
            int currentVertex = current.getVertex();
            int currentDistance = current.getDistance();


            if(distance[currentVertex] < currentDistance) continue;
            //만약 기록된 최단거리보다 현재 거리가 더 크다면, 해당 노드는 이미 최단거리 갱신이 된 노드이므로 건너뛴다.



            for(int i = 0; i< graph.get(currentVertex).size(); i++){ //현재 정점과 연결된 간선(혹은 Node)의 길이만큼 반복
                /**
                 * 거리 비교하여 최단거리 설정
                 */
                Node nextNode = graph.get(currentVertex).get(i);
                if(distance[nextNode.getVertex()] > nextNode.getDistance() + distance[currentVertex] ){
                    distance[nextNode.getVertex()] = nextNode.getDistance() + distance[currentVertex];
                    pq.add(new Node(nextNode.getVertex(), distance[nextNode.getVertex()]));
                }


            }
        }




    }



    private static class Node implements Comparable<Node>{
        private int vertex;
        private int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public int getVertex() {
            return vertex;
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
