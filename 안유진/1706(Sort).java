import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       StringTokenizer st = new StringTokenizer(br.readLine()," ");

       int R = Integer.parseInt(st.nextToken());
       int C = Integer.parseInt(st.nextToken());

       char arr[][] = new char[R][C];
       LinkedList<String> set = new LinkedList<>();


       for(int i = 0; i < R; i++){
           String s = br.readLine();
           for(int j = 0; j < C; j++){
               arr[i][j] = s.charAt(j);
           }
           st = new StringTokenizer(s, "#");
           while (st.hasMoreTokens()){
               String next = st.nextToken();
               if(next.length() != 1){
                   set.add(next);
               }
           }
       }

        for(int i = 0; i < C; i++){
           StringBuilder temp = new StringBuilder();
           for(int j = 0; j < R; j++){
                temp.append(arr[j][i]);
           }
            st = new StringTokenizer(String.valueOf(temp), "#");
            while (st.hasMoreTokens()){
                String next = st.nextToken();
                if(next.length() != 1){
                    set.add(next);
                }
            }
       }
        Collections.sort(set);
        System.out.println(set.get(0));
    }
}
