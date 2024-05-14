package Floyd_Warshall;

import java.io.*;
import java.util.*;

public class backjoon_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Party party = new Party(n, m, x);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            party.addNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        party.startfloyd_warshall();
        bw.write(party.getMax() + "\n");
        bw.flush();
        bw.close();
    }
}

class Party {
    private int partyhouse = 0;
    private int[][] dis;
    private int max = -1;
    Party(int n, int m, int x) {
        dis = new int[n + 1][n  + 1];
        for (int i = 0; i < dis.length; i++) {
            Arrays.fill(dis[i], 1000000000);
            dis[i][i] = 0;
        }
        partyhouse = x;
    }
    void addNode(int a, int b, int c) {
        if (c < dis[a][b]) dis[a][b] = c;
    }
    void startfloyd_warshall() {
        for (int k = 1; k < dis.length; k++) {
            for (int i = 1; i < dis.length; i++) {
                for (int j = 1; j < dis.length; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        for (int i = 1; i < dis.length; i++) {
            if (max < dis[partyhouse][i] + dis[i][partyhouse]) max = dis[partyhouse][i] + dis[i][partyhouse];
        }
    }

    public int getMax() {
        return max;
    }
}