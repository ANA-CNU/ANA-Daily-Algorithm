import java.util.*;
import java.io.*;

public class Naong {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int left = A%B;

        for(int i = 0; i<n-1; i++){
            left*=10;
            left = left%B;
        }
        System.out.println((left*10)/B);
    }
}
