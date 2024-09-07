import java.io.*;
import java.util.*;

public class Main {
    static void prime(boolean[] arr, int n) {
        arr[0] = arr[1] = true;

        for ( int i = 2 ; i*i <= n ; i++ )
            if ( !arr[i] )
                for ( int j = i*i ; j <= n ; j += i )
                    arr[j] = true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[n+1];

        prime(isPrime, n);

        ArrayList<Integer> primeNum = new ArrayList<>();
        for ( int i = 1 ; i <= n ; i++ )
            if ( !isPrime[i] )
                primeNum.add(i);

        int start = 0;
        int end = 0;
        int cnt = 0;
        int sum = 0;

        while ( true ) {
            if ( sum >= n )
                sum -= primeNum.get(start++);
            else if ( end == primeNum.size() )
                break;
            else
                sum += primeNum.get(end++);                
            
            if ( sum == n )
                cnt++;
        }

        System.out.println(cnt);
    }
}