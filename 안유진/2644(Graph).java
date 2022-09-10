import java.util.*;
import java.io.*;

public class Meow {
    static LinkedList<Integer> linkedList[];
    static boolean check[];
    static int N;
    static int target;
    static int count;
    static boolean flag = false;

    static void DFS(int num, int cnt){
        check[num] = true;

        if(num == target){
            count = cnt;
            flag = true;
            return;
        }

        for(int temp : linkedList[num]){
            if(!check[temp]){
                DFS(temp, cnt+1);
            }
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        linkedList = new LinkedList[N + 1];
        check = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++){
            linkedList[i] = new LinkedList<>();
        }

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            linkedList[a].add(b);
            linkedList[b].add(a);
        }

        for(int i = 0; i < N + 1; i++){
            Collections.sort(linkedList[i]);
        }

        DFS(start, 0);
        if(flag){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
