import java.util.*;
import java.io.*;

class Main {
    static int N;
    static int M;
    static int S;

    static int currentVisit = 1;
    static ArrayList<Integer> arrayList[];
    static int arr[];
    static boolean visited[];
    public static void dfs(int start) {
        arr[start] = currentVisit;
        visited[start] = true;
        currentVisit++;
        for(int temp : arrayList[start]) {
            if(!visited[temp]) {
                dfs(temp);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N + 1];
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i < N + 1; i++) {
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

        dfs(S);

        for(int i = 1; i < N + 1; i++) {
            System.out.println(arr[i]);
        }
    }
}
