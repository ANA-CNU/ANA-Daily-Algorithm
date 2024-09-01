import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s13238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int result = 0;

        for ( int i = 0 ; i < n ; i++ ) {
            int bit = Integer.parseInt(st.nextToken());

            min = Math.min(min, bit);
            result = Math.max(result, bit-min);
        }

        System.out.println(result);
    }
}
