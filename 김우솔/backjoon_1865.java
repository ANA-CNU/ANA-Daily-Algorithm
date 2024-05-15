package BellmanFord;

import java.io.*;
import java.util.*;

public class backjoon_1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            Graph g = new Graph(n, m, w);

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                g.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());
                g.addW(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), -Integer.parseInt(st.nextToken()));
            }

            if (g.startbellmanford()) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }

        }

        bw.flush();
        bw.close();
    }
}

class Graph {
    private int n;
    private int m;
    private int[] dis;
    private ArrayList<Node> adj;

    Graph(int n, int m, int w) {
        dis = new int[n + 1];
        this.n = n;
        this.m = m * 2 + w;
        adj = new ArrayList();
    }

    void addNode(int a, int b, int c) {
        adj.add(new Node(a, b, c));
        adj.add(new Node(b, a, c));
    }

    void addW(int a, int b, int c) {
        adj.add(new Node(a, b, c));
    }

    boolean startbellmanford() {
        Arrays.fill(dis, 2000000000);
        dis[1] = 0;
        /**
         * 음수의 사이클 '만' 찾으면 된다
         * 따라서 이 코드에서는 위의 두줄을 지워도 성립한다
         * 그래서 if문에 dis == INF같은 조건문도 제외돼있음
         */
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                Node node = adj.get(j);

                if (dis[node.w] > dis[node.v] + node.cost) {
                    dis[node.w] = dis[node.v] + node.cost;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            Node node = adj.get(j);
            if (dis[node.w] > dis[node.v] + node.cost) {
                return true;
            }
        }
        return false;
    }
}

class Node {
    int v;
    int w;
    int cost;

    Node(int v, int w, int cost) {
        this.v = v;
        this.w = w;
        this.cost = cost;
    }
}