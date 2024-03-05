import java.io.*;
import java.util.*;
public class Boj12851 {
    static int n, k;
    static int result , cnt=0;
    static int[] map = new int[100001];
    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int time = cur[1];
            int[] x_list = {x - 1, x + 1, x * 2};
            if (x == k) {
                if (time < result) {
                    result = time;
                    cnt = 1;
                } else if (time == result) {
                    cnt++;
                }
            }
            for (int i = 0; i < 3; i++) {
                int nx = x_list[i];
                if (nx < 0 || nx > 100000) continue;
                if (map[nx] >= time + 1) {
                    map[nx] = time + 1;
                    q.add(new int[]{nx, time + 1});
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        for(int i=0; i<100001; i++)
            map[i]=Integer.MAX_VALUE;
        cnt=bfs();
        System.out.println(result);
        System.out.println(cnt);
    }
}
