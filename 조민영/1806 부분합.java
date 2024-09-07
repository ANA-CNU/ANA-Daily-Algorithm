import java.io.*;
import java.util.*;

public class g1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for ( int i = 0 ; i < n ; i++ )
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        boolean exist = false;

        while ( true ) {
            if ( sum >= s ) {
                min = Math.min(min, end-start);
                sum -= arr[start++];
                exist = true;
            } else if ( end == n ) 
                break;
            else
                sum += arr[end++];
        }

        System.out.println(exist ? min : 0 );
    }
}