package BFS;

import java.io.*;
import java.util.*;
public class backjoon_23040 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Nutella nu = new Nutella(N);

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            nu.addM(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> al = new ArrayList<>();
        String check = br.readLine();

        for (int i = 0; i < check.length(); i++) {
            if (check.charAt(i) == 'R') {
                al.add(i + 1);
            }else {
                nu.addRB(i + 1);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            nu.startNutella(al.get(i));
        }

        bw.write(nu.getSum() + "\n");
        bw.flush();
        bw.close();
    }
}

class Nutella {
    private ArrayList[] adj;
    private boolean[] vis;
    private boolean[] B;
    private long sum = 0;
    Nutella(int a) {
        adj = new ArrayList[a + 1];
        vis = new boolean[a + 1];
        B = new boolean[a + 1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList();
        }
    }

    void addM(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }
    void addRB(int a) {
        B[a] = true;
    }
    void startNutella(int st) {
        if (vis[st]) return;
        long red = 0;
        long black = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(st);
        vis[st] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            red++;

            Iterator<Integer> it = adj[temp].iterator();
            while (it.hasNext()) {
                int a = it.next();
                if (!vis[a] && !B[a]) { //갈곳이 빨간색노드일경우
                    vis[a] = true;
                    queue.add(a);
                } else if (B[a]) { //갈곳이 검은색노드일경우
                    black++;
                }
            }
        }
        sum += red * black;
    }

    public long getSum() {
        return sum;
    }
}