import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = "";

        while (true){
            s = br.readLine();
            if(s.equals("0")){
                break;
            }

            int n = Integer.parseInt(s);

            boolean arr[] = new boolean[246913];

            arr[0] = true;
            arr[1] = true;

            for(int i = 2; i <= Math.sqrt(arr.length); i++){
                if(arr[i]){
                    continue;
                }
                for(int j = i*i; j < arr.length; j += i){
                    arr[j] = true;
                }
            }

            long total = 0;
            for(int i = n + 1; i < 2 * n + 1; i++){
                if(!arr[i]){
                    total++;
                }
            }
            sb.append(total).append('\n');
        }
        System.out.println(sb);
    }
}
