package baekjoon2024September;

import java.util.*;
import java.io.*;

public class n3197 {

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int r, c;
    static int[][] dirs = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        boolean[][] visited = new boolean[r][c];

        Queue<Node> swanQueue = new LinkedList<>();
        Queue<Node> nextSwanQueue = new LinkedList<>();
        Queue<Node> iceQueue = new LinkedList<>();
        int[] swans = new int[4];
        int swanCount = 0;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'L') {
                    if (swanCount == 0) {
                        swans[0] = i;
                        swans[1] = j;
                        swanQueue.offer(new Node(i, j));
                        visited[i][j] = true;
                    } else {
                        swans[2] = i;
                        swans[3] = j;
                    }
                    map[i][j] = '.';
                    swanCount++;
                }

                if (map[i][j] == '.') {
                    iceQueue.offer(new Node(i, j));
                }
            }
        }

        int days = 0;

        while (true) {
            if (swanBFS(map, swans[2], swans[3], swanQueue, nextSwanQueue, visited)) {
                System.out.println(days);
                break;
            }

            iceQueue = meltIce(map, iceQueue);

            swanQueue = nextSwanQueue;
            nextSwanQueue = new LinkedList<>();
            days++;
        }
    }

    static boolean swanBFS(char[][] map, int L2x, int L2y, Queue<Node> swanQueue, Queue<Node> nextSwanQueue, boolean[][] visited) {
        while (!swanQueue.isEmpty()) {
            Node n = swanQueue.poll();
            int x = n.x;
            int y = n.y;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && !visited[nx][ny]) {
                    visited[nx][ny] = true;

                    if (nx == L2x && ny == L2y) {
                        return true;
                    }

                    if (map[nx][ny] == '.') {
                        swanQueue.offer(new Node(nx, ny));
                    } else if (map[nx][ny] == 'X') {
                        nextSwanQueue.offer(new Node(nx, ny));
                    }
                }
            }
        }
        return false;
    }

    static Queue<Node> meltIce(char[][] map, Queue<Node> iceQueue) {
        Queue<Node> newIceQueue = new LinkedList<>();

        while (!iceQueue.isEmpty()) {
            Node n = iceQueue.poll();
            int x = n.x;
            int y = n.y;

            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] == 'X') {
                    map[nx][ny] = '.';
                    newIceQueue.offer(new Node(nx, ny));
                }
            }
        }
        return newIceQueue;
    }
}
