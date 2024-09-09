import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N+1];
        for ( int i = 1 ; i <= N ; i++ )
            arr[i] = Integer.parseInt(st.nextToken());

        int[] visited = new int[100_001];

        int s = 1;
        int e = 0;
        long ans = 0L;

        while ( s <= N ) {
            while ( e < N && visited[arr[e+1]] == 0 )
                visited[arr[++e]] = 1;

            ans += e-s+1;
            visited[arr[s++]] = 0;
        }

        System.out.println(ans);
    }
}