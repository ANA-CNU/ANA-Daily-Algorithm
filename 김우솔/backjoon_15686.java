package notyet;

import java.io.*;
import java.util.*;

public class backjoon_15686 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ChickenDelivery cd = new ChickenDelivery(N, M);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cd.addNode(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        cd.setChvis();
        cd.CheckChicken(0, 0);
        bw.write(cd.getMin() + "\n");
        bw.flush();
        bw.close();
    }
}

class ChickenDelivery {
    private int[][][] adj; //좌표 + map
    private int min = Integer.MAX_VALUE;
    private int chickenhosue;
    private boolean[] chvis;
    private ArrayList<int[]> arrayList;
    private ArrayList<int[]> house;
    private int[] updown = {1, 0, -1, 0};
    private int[] leftright = {0, 1, 0, -1};

    ChickenDelivery(int a, int b) {
        adj = new int[a][a][3];
        chickenhosue = b;
        arrayList = new ArrayList();
        house = new ArrayList();
    }
    void addNode(int a, int b, int c) {
        adj[a][b][0] = a;
        adj[a][b][1] = b;
        adj[a][b][2] = c;
        if (c == 1) {
            house.add(new int[]{a, b}); //집좌표
        }
        if (c == 2) {
            adj[a][b][2] = 0;
            arrayList.add(new int[]{a, b}); //치킨좌표
        }
    }
    public void setChvis() {
        chvis = new boolean[arrayList.size()];
    }
    void CheckChicken(int depth, int at) {
        if (depth == chickenhosue) {
            StartBFS();
            return;
        }

        for (int i = at; i < chvis.length; i++) {
            if (!chvis[i]) {
                chvis[i] = true;
                CheckChicken(depth + 1, i + 1);
                chvis[i] = false;
            }
        }
    }

    void StartBFS() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < chvis.length; i++) {
            if (chvis[i]) {
                int[] temp = arrayList.get(i);
                adj[temp[0]][temp[1]][2] = 2;
            }
        }
        int count = 0;
        for (int i = 0; i < house.size(); i++) {
            queue.clear();
            boolean[][] vis = new boolean[adj.length][adj.length];
            int[] x = house.get(i);
            queue.add(adj[x[0]][x[1]]);
            vis[x[0]][x[1]] = true;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();

                if (temp[2] == 2) {
                    count += Math.abs(temp[0] - x[0]) + Math.abs(temp[1] - x[1]);
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int ud = updown[j] + temp[0];
                    int lr = leftright[j] + temp[1];
                    if (ud < 0 || lr < 0 || ud >= adj.length || lr >= adj.length) continue;
                    if (vis[ud][lr]) continue;
                    vis[ud][lr] = true;
                    queue.add(adj[ud][lr]);
                }
            }
        }
        if (count < min) min = count;

        for (int i = 0; i < chvis.length; i++) {
            if (chvis[i]) {
                int[] temp = arrayList.get(i);
                adj[temp[0]][temp[1]][2] = 0;
            }
        }
    }

    public int getMin() {return min;}
}