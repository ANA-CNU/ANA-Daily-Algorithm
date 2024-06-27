package BFS;

import java.io.*;
import java.util.*;

public class backjoon_2636 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Cheezeeazy cheezeeazy = new Cheezeeazy(n, m);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheezeeazy.addArray(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        cheezeeazy.StartCheeze();
        bw.write(cheezeeazy.getcount() + "\n" + cheezeeazy.getGetsize() + "\n");
        bw.flush();
        bw.close();
    }
}

class Cheezeeazy {
    //외부 빈공간 2 치즈 1 내부 빈공간 0
    /**
     * 0을 2로 bfs돌리고
     * 0인 부분은 냅둠
     * 1인부분 중에서 2와 만나는 곳이 2개이면 체크
     * 이후 체크한곳을 3을 바꿈
     * 2를 다시 0으로 바꿔 3도 0으로 바꿔// 요건 그냥 바꾸기
     *
     * 위의 과정을 반복하면서 1이나 0인 부분이 없으면 종료
     */
    private int[][][] map;
    private int count = 0;
    private int getsize = 0;
    private int[] updown = {0, 1, 0, -1};
    private int[] leftright = {1, 0, -1, 0};
    private ArrayList<int[]> list = new ArrayList<>();
    Cheezeeazy(int n, int m) {
        map = new int[n][m][3];
    }
    void addArray(int a, int b, int val) {
        map[a][b][0] = a;
        map[a][b][1] = b;
        map[a][b][2] = val;
        if (val == 1) list.add(map[a][b]);
    }
    void StartCheeze() {
        while (true) {
            if (list.isEmpty()) return;
            getsize = list.size();
            Queue<int[]> q = new LinkedList<>();
            map[0][0][2] = 2;
            q.add(map[0][0]);

            while (!q.isEmpty()) {
                int[] temp = q.poll();

                for (int i = 0; i < 4; i++) {
                    int ud = updown[i] + temp[0];
                    int lr = leftright[i] + temp[1];
                    if (ud < 0 || ud >= map.length || lr < 0 || lr >= map[0].length) continue;
                    if (map[ud][lr][2] == 2 || map[ud][lr][2] == 1) continue;
                    map[ud][lr][2] = 2;
                    q.add(map[ud][lr]);
                }
            }
            //bfs완
            for (int i = list.size() - 1; i >= 0; i--) {
                int[] temp = list.get(i);
                int empty = 0;
                for (int j = 0; j < 4; j++) {
                    if (map[temp[0] + updown[j]][temp[1] + leftright[j]][2] == 2) empty++;
                }
                if (empty >= 1) {
                    map[temp[0]][temp[1]][2] = 3;
                }
            }
            //치즈 바꾸기
            list.clear();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {
                    if (map[i][j][2] >= 2) {
                        map[i][j][2] = 0;
                    }else if (map[i][j][2] == 1) {
                        list.add(map[i][j]);
                    }
                }
            }
            count++;
        }
    }

    public int getcount() {
        return count;
    }

    public int getGetsize() {
        return getsize;
    }
}
