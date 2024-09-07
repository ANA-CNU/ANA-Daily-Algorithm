import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s2559 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int result = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());

        for ( int i = 1 ; i <= n ; i++ )
            arr[i] = Integer.parseInt(st.nextToken())+arr[i-1];

        for ( int i = k ; i <= n ; i++ ) {
            int sum = arr[i]-arr[i-k];

            result = Math.max(result,sum);
        }

        System.out.println(result);
    }
}
