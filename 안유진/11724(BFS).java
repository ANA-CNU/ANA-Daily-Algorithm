import java.util.*;
import java.io.*;

public class Meow {
    static int N; //number of vertex
    static int M; //number of edge
    static int count; //counting connected component

    static ArrayList<Integer> list[];
    static boolean check[];

    public static void BFS(int start){ //Using BFS for searching unvisited node
        Queue<Integer> queue = new LinkedList<>();

        if(!check[start]){
            count++;
        }

        check[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int temp = queue.remove();
            for(int num : list[temp]){
                if(!check[num]){
                    check[num] = true;
                    queue.add(num);
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        check = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            list[i] = new ArrayList<>(); //initiating arraylist
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[start].add(end); //adding vertex
            list[end].add(start);
        }

        for(int i = 1; i < N + 1; i++){
            BFS(i);
        }

        System.out.println(count);
    }
}
