import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList[] = new ArrayList[N + 1];
        int indegree[] = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList[a].add(b);
            indegree[b]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 1; i <= N; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.remove();
            sb.append(current).append(" ");

            for(int next : arrayList[current]){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
