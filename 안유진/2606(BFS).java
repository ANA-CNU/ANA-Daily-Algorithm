import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Integer> list[];
    static boolean visited[];

    static int node;

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int temp = queue.remove();

            for(int num : list[temp]){
                if(!visited[num]){
                    visited[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        list = new LinkedList[node + 1];
        visited = new boolean[node + 1];

        for(int i = 0; i < node + 1; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end);
            list[end].add(start);

            Collections.sort(list[start]);
            Collections.sort(list[end]);
        }
        bfs(1);

        int count = 0;
        for(int i = 2; i < node + 1; i++){
            if(visited[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
