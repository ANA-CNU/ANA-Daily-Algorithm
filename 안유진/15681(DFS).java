import java.util.*;
import java.io.*;

public class Main {
    static int N,R,Q;
    static ArrayList<Integer>[] arrayLists;
    static boolean visited[];
    static int count[];
    public static int dfs(int root) {
        int totalNum = 1;
        for(int i = 0; i < arrayLists[root].size(); i++) {
            int currentRoot = arrayLists[root].get(i);
            if(!visited[currentRoot]) {
                visited[currentRoot] = true;
                totalNum += dfs(currentRoot);
            }
        }

        count[root] = totalNum;
        return totalNum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arrayLists = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        count = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayLists[start].add(end);
            arrayLists[end].add(start);
        }

        visited[R] = true;
        dfs(R);


        for(int i = 0; i < Q; i++) {
            int root = Integer.parseInt(br.readLine());
            System.out.println(count[root]);
        }
    }
}
