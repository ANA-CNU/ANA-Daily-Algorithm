import java.io.*;
import java.util.*;

class Shark {
    int speed, direction, size;

    Shark(int speed, int direction, int size) {
        this.speed = speed;
        this.direction = direction;
        this.size = size;
    }
}

public class Boj17143 {
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 1, -1};
    static Shark[][] map;
    static int R, C, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R + 1][C + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            map[x][y] = new Shark(speed, direction, size);
        }

        int result = 0;

        for (int i = 1; i <= C; i++) {
            for (int j = 1; j <= R; j++) {
                if (map[j][i] != null) {
                    result += map[j][i].size;
                    map[j][i] = null;
                    break;
                }
            }
            map = moveSharks();
        }
        System.out.println(result);
    }
    static Shark[][] moveSharks() {
        Shark[][] temp = new Shark[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (map[i][j] != null) {
                    Shark shark = map[i][j];
                    int x = i;
                    int y = j;
                    int speed = shark.speed;
                    if (shark.direction == 1 || shark.direction == 2) {
                        speed %= (2 * R - 2);
                    } else {
                        speed %= (2 * C - 2);
                    }
                    for (int s = 0; s < speed; s++) {
                        if (shark.direction == 1 && x == 1) {
                            shark.direction = 2;
                        } else if (shark.direction == 2 && x == R) {
                            shark.direction = 1;
                        } else if (shark.direction == 3 && y == C) {
                            shark.direction = 4;
                        } else if (shark.direction == 4 && y == 1) {
                            shark.direction = 3;
                        }
                        x += dx[shark.direction];
                        y += dy[shark.direction];
                    }
                    if (temp[x][y] == null) {
                        temp[x][y] = shark;
                    } else {
                        if (temp[x][y].size < shark.size) {
                            temp[x][y] = shark;
                        }
                    }
                }
            }
        }
        return temp;
    }
}
