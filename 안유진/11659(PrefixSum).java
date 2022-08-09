import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine()," ");
       StringBuilder sb = new StringBuilder();

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());

       int arr[] = new int[N];
       st = new StringTokenizer(br.readLine()," ");

       for(int i = 0; i < N; i++){
           arr[i] = Integer.parseInt(st.nextToken());
       }
       for(int i = 1; i < N; i++){
           arr[i] = arr[i-1] + arr[i];
       }
       for(int i = 0; i < M; i++){
           st = new StringTokenizer(br.readLine()," ");
           int start = Integer.parseInt(st.nextToken())-1;
           int end = Integer.parseInt(st.nextToken())-1;

           if(start == 0){
               sb.append(arr[end]).append('\n');
           }else{
               sb.append(arr[end] - arr[start-1]).append('\n');
           }
       }
        System.out.println(sb);
    }
}
