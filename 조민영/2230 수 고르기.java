import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for ( int i = 0 ; i < N ; i++ )
            A[i] = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while ( end < N ) {
            int diff = A[end] - A[start];

            if ( diff < M )
                end++;
            else if ( diff > M ) {
                min = Math.min(min, diff);
                start++;
            } else {
                min = diff;
                break;
            }
        }

        System.out.println(min);
    }
}