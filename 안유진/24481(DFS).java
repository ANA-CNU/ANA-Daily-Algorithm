import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int R;

    static ArrayList<Integer> arrayList[];
    static int depth[];
    static boolean visited[];

    public static void dfs(int start, int dep) {
        visited[start] = true;
        depth[start] = dep;

        for(int next : arrayList[start]) {
            if(!visited[next]) {
                dfs(next, dep+1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList[start].add(end);
            arrayList[end].add(start);
        }

        for(int i = 1; i < N + 1; i++) {
            Collections.sort(arrayList[i]);
        }

        Arrays.fill(depth, -1);

        dfs(R, 0);
        depth[R] = 0;

        for(int i = 1; i < N + 1; i++) {
            System.out.println(depth[i]);
        }
    }
}
