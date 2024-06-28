package BFS;

import java.io.*;
import java.util.*;

public class backjoon_16236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Shark shark = new Shark(n);
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                shark.addMap(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        shark.StratEatFish();
        bw.write(shark.getTime() + "\n");
        bw.flush();
        bw.close();
    }
}

class Shark {
    private int[][][] map;//0 y좌표 1 x좌표 2 지도값 3 시간값
    private boolean[][] vis;
    private int[] updown = {-1, 0, 1, 0};
    private int[] leftright = {0, -1, 0, 1};
    private int time = 0;
    private int[] startpoint;
    private int sharkbody = 2;
    private int eatfish = 0;
    private ArrayList<int[]> fishpoint = new ArrayList<>();
    /**
     * 구현을 어떻게 할거냐 생각을 해보자
     * 물고기 123456
     * 나 9
     * 더이상 먹을수 있는게 없으면 종료
     * 종료 조건은 bfs를 돌렸을때 먹이가 체크가 안되면 종료
     * 먹이체크는 크기에 따라 한다
     * <p>
     * 물고기가 있으면 그거 먹으러감
     * 위왼쪽 순서대로 우선순위
     * 먹은 후는 빈칸
     * <p>
     * 자기몸과 같은 수를 먹으면 크기가 오름
     */

    Shark(int n) {
        map = new int[n][n][4];
        vis = new boolean[n][n];
    }

    void addMap(int a, int b, int val) {
        map[a][b][0] = a;
        map[a][b][1] = b;
        map[a][b][2] = val;
        if (val == 9) {
            startpoint = map[a][b];
        }
    }

    void StratEatFish() {
        /**
         * bfs를 계속 돌림
         * 자기 몸보다 크면 벽으로 간주
         * 자기 몸보다 만약 꺼낸게 작다?
         * 그러면 bfs를 중지하고 그 칸으로 이동
         * (이 과정을 다시 따로 구현해줘야 할듯 )----------
         * 칸으로 이동하면서 좌표값 계산해주고
         * (이것도 이동하면서 다시 해줘야핳듯)
         * 칸을 바꿔줌
         * 몸집 키워줌
         * 다시 bfs 진행 만약 꺼낸게 없이 bfs가 끝날 경우 프로그램 종료
         *
         * 갔던 칸을 안가도록 stack에 담는다?
         * 간 칸을 true로 바꾸고
         * stack을 뽑으면서 갔던 true를 다시 false으로 바꿔준다
         * 아님 그냥 다 초기화 시켜버려~
         */
        while (true) {
            int timecheck = 1000;
            Queue<int[]> q = new LinkedList<>();
            q.add(startpoint);
            vis[startpoint[0]][startpoint[1]] = true;

            while (!q.isEmpty()) {
                int[] temp = q.poll();
                if (temp[2] < sharkbody && 0 < temp[2]) {
                    //이 위치로 이동
                    // 여러개를 담아줘야겠다
                    if (timecheck >= temp[3]) {
                        fishpoint.add(temp);
                        timecheck = temp[3];
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int ud = updown[i] + temp[0];
                    int lr = leftright[i] + temp[1];
                    if (ud < 0 || ud >= map.length || lr < 0 || lr >= map.length) continue;;
                    if (map[ud][lr][2] > sharkbody) continue;
                    if (vis[ud][lr]) continue;
                    map[ud][lr][3] = map[temp[0]][temp[1]][3] + 1;
                    vis[ud][lr] = true;
                    q.add(map[ud][lr]);
                }
            }

            for (int i = 0; i < vis.length; i++) {
                for (int j = 0; j < vis.length; j++) {
                    vis[i][j] = false;
                    map[i][j][3] = 0;
                }
            }

            int[] t;
            if (fishpoint.isEmpty()) {
                break;
            } else if (fishpoint.size() == 1) {
                t = fishpoint.get(0);
            }else {
                t = fishpoint.get(0);
                for (int i = 1; i < fishpoint.size(); i++) {
                    int[] ex = fishpoint.get(i);
                    if (ex[0] < t[0]) {
                        t = ex;
                    } else if (ex[0] == t[0]) {
                        if (ex[1] < t[1]) {
                            t = ex;
                        }
                    }
                }
            }
            time += timecheck;
            map[startpoint[0]][startpoint[1]][2] = 0;
            map[t[0]][t[1]][2] = 9;
            t[2] = 9;
            startpoint = t;
            eatfish++;
            if (sharkbody == eatfish) {
                sharkbody++;
                eatfish = 0;
                if (sharkbody >= 7) {
                    sharkbody = 7;
                }
            }
            fishpoint.clear();
        }
    }

    public int getTime() {
        return time;
    }
}
