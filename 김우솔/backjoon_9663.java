package BackTracking;

import java.io.*;

public class backjoon_9663 {
    static int count = 0;
    static int num;
    static boolean[] visited;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        num = Integer.parseInt(br.readLine());
        visited = new boolean[num];
        arr = new int[num][num];
        NQueen(0);

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
    static void NQueen(int depth) {

        if (depth == num) {
            count++;
        }

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                visited[i] = true;

                if (arr[i][depth] > 0) {
                    visited[i] = false;
                    continue;
                }

                arr[i][depth]++;
                int y = -1, x = 1;
                while (true) {
                    if (y + i < 0 || x + depth >= arr.length) break;
                    arr[y + i][x + depth]++;
                    y--;
                    x++;
                }
                int b = 1, a = 1;
                while (true) {
                    if (b + i >= arr.length || a + depth >= arr.length) break;
                    arr[b + i][a + depth]++;
                    b++;
                    a++;
                }
                NQueen(depth + 1);
                while (true) {
                    if (x == 1 && y == -1) break;
                    y++;
                    x--;
                    arr[y + i][x + depth]--;
                }
                while (true) {
                    if (a == 1 && b == 1) break;
                    b--;
                    a--;
                    arr[b + i][a + depth]--;
                }
                arr[i][depth]--;

                visited[i] = false;
            }
        }
    }
}
