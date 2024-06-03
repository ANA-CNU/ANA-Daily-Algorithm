package baekjoon;
import java.util.*;

class Node {
    int x, y, smash, dist;
    
    Node(int x, int y, int smash, int dist) {
        this.x = x;
        this.y = y;
        this.smash = smash;
        this.dist = dist;
    }
}

public class m2206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        boolean[][] map = new boolean[N][M];
        boolean[][][] visited = new boolean[2][N][M];
        int[][][] result = new int[2][N][M];

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) == '0';
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            int smash = node.smash;
            int dist = node.dist;

            if (x == N - 1 && y == M - 1) {
                System.out.println(dist);
                return;
            }

            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] && !visited[smash][nx][ny]) {
                        visited[smash][nx][ny] = true;
                        result[smash][nx][ny] = dist + 1;
                        queue.offer(new Node(nx, ny, smash, dist + 1));
                    } else if (!map[nx][ny] && smash == 0 && !visited[1][nx][ny]) {
                        visited[1][nx][ny] = true;
                        result[1][nx][ny] = dist + 1;
                        queue.offer(new Node(nx, ny, 1, dist + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
