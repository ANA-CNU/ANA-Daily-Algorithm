import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sol = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for ( int i = 0 ; i < N ; i++ )
            sol[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sol);

        int start = 0;
        int end = N-1;
        int temp = 0;
        int sum = 0;
        int[] res = new int[2];
        int min = Integer.MAX_VALUE;

        while ( start < end ) {
            sum = sol[start]+sol[end];
            temp = Math.abs(sum);
            
            if ( temp < min ) {
                min = temp;
                res[0] = sol[start];
                res[1] = sol[end];
            }

            if ( temp == 0 )
                break;

            if ( sum > 0 )
                end--;
            else
                start++;
        }

        System.out.println( res[0] + " " + res[1] );
    }
}