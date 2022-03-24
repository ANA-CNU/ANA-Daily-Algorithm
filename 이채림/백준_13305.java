import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_13305 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] len = br.readLine().split(" ");
        String[] liter = br.readLine().split(" ");

        long min = Long.parseLong(liter[0]);
        long cost = 0;

        for(int i = 0; i < N-1; i++){
            if(min >= Long.parseLong(liter[i])){
                min = Long.parseLong(liter[i]);     
            }       
            cost = cost + (min * Long.parseLong(len[i]));
         }

         System.out.println(cost);
    }
}
