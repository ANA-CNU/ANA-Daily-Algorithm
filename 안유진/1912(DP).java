import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int max = -1000;

        int arr[] = new int[N];
        int store[] = new int[N];

        for(int i = 0 ; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        store[0] = arr[0];

        for(int i = 1; i < N; i++){
            int sum = store[i-1] + arr[i];
            int big = Math.max(sum, arr[i]);
            store[i] = big;
        }

        for(int i = 0; i< N; i++){
            max = Math.max(store[i],max);
        }

        System.out.println(max);
    }
}
