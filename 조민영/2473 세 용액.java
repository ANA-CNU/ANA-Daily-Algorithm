import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] sol = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for ( int i = 0 ; i < N ; i++ )
            sol[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sol);

        long[] res = new long[3];
        long min = Long.MAX_VALUE;

        for ( int i = 0 ; i < N-2 ; i++ ) {
            int start = i;
            int mid = i+1;
            int  end = N-1;
            while ( mid < end ) {
                long sum = sol[start]+sol[mid]+sol[end];
                long temp = Math.abs(sum);
                
                if ( temp < min ) {
                    min = temp;
                    res = new long[]{sol[start], sol[mid], sol[end]};
                }

                if ( temp == 0 )
                    break;

                if ( sum > 0 )
                    end--;
                else
                    mid++;
            }
        }

        System.out.println( res[0] + " " + res[1] + " " + res[2] );
    }
}