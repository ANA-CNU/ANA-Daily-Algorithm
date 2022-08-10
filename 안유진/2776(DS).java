import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
    
       int T = Integer.parseInt(br.readLine());
       while (T --> 0){
           int N = Integer.parseInt(br.readLine());

           HashSet<Integer> set = new HashSet<>();

           StringTokenizer st = new StringTokenizer(br.readLine()," ");
           for(int i = 0; i < N; i++){
               int temp = Integer.parseInt(st.nextToken());
               set.add(temp);
           }

           int M = Integer.parseInt(br.readLine());
           st = new StringTokenizer(br.readLine()," ");
           for(int i = 0; i < M; i++){
               int temp = Integer.parseInt(st.nextToken());
               if(set.contains(temp)){
                   sb.append(1).append('\n');
               }else{
                   sb.append(0).append('\n');
               }
           }
       }
        System.out.println(sb);
    }
}
