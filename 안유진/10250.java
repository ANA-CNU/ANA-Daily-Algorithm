import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i<T; i++){
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());


            if(N%H == 0){
                sb.append((H*100) + N/H);
            }else{
                sb.append((N%H)*100 + (N/H)+1);
            }

            sb.append('\n');

        }
        System.out.println(sb);
    }
}