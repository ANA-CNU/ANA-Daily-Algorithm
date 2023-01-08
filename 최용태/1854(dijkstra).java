import java.util.*;
import java.io.*;

public class Main_1 {
    static int N;
    static int M;
    static int K;
    static int[] sizeSet;
    static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
    static ArrayList<PriorityQueue<Integer>> result = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        K = Integer.parseInt(s.nextToken());

        sizeSet = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            result.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(ss.nextToken());
            int e = Integer.parseInt(ss.nextToken());
            int v = Integer.parseInt(ss.nextToken());

            graph.get(f).add(new Edge(e, v));
            sizeSet[f]++;
        } // 입력 완료

        search();

        StringBuilder sb=new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            PriorityQueue<Integer> pq = result.get(i);
            if (pq.size() < K) {
                sb.append(-1+"\n");
            } else {
                sb.append(pq.peek() + "\n");
            }
        }
        System.out.println(sb);
    }

    static void search() {
        PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });

        q.offer(new Edge(1, 0)); // start==1
        result.get(1).offer(0);
        while (!q.isEmpty()) {
            Edge currentNode = q.poll();
            int ctn=currentNode.toNode;
            int cv=currentNode.value;
            for (int i = 0; i < sizeSet[ctn]; i++) {
                Edge targetNode = graph.get(ctn).get(i);
                int ttn=targetNode.toNode;
                int tv=targetNode.value;

                if (result.get(ttn).size() < K) {
                    result.get(ttn).offer(tv+cv);
                    q.offer(new Edge(ttn, tv + cv));
                } else{
                    if (tv + cv < result.get(ttn).peek()) {
                        result.get(ttn).poll();
                        result.get(ttn).offer(tv+cv);
                        q.offer(new Edge(ttn, tv + cv));
                    }
                }
            }
        }
    }
}

class Edge{
    int toNode;
    int value;

    Edge(int t, int v) {
        toNode = t;
        value = v;
    }
}