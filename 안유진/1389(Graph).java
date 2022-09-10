import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static LinkedList<Integer> linkedList[];
    static int store[];
    static int min = Integer.MAX_VALUE;

    //최소값을 저장해야함.
    static int BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean check[] = new boolean[N + 1];
        int arr[] = new int[N + 1];

        int count = 0;

        check[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int temp = queue.remove();

            for(int num : linkedList[temp]){
                if(!check[num]){
                    arr[num] = arr[temp] + 1;
                    check[num] = true;
                    queue.add(num);
                }
            }
            count += arr[temp];
        }
        if(min > count){
            min = count;
        }
        return count;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        linkedList = new LinkedList[N + 1];
        store = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            linkedList[i] = new LinkedList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            linkedList[x].add(y);
            linkedList[y].add(x);
        }
        for(int i = 0; i < N + 1; i++){
            Collections.sort(linkedList[i]);
        }

        for(int i = 1; i < N + 1; i++){
            store[i] = BFS(i);
        }

        for(int i = 1; i < N + 1; i++){
            if(store[i] == min){
                System.out.println(i);
                break;
            }
        }
    }
}
