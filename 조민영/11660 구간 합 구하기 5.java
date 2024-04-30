import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

		int [][] arr = new int[n+1][n+1];
		int [][] sum = new int [n+1][n+1];

		for ( int i = 0 ; i < n ; i++ ) {
			st = new StringTokenizer(br.readLine());
			for ( int j = 0 ; j < n ; j++ ) {
				arr[i+1][j+1] = Integer.parseInt(st.nextToken());
				sum [i+1][j+1] = arr[i+1][j+1] + sum[i][j+1] + sum[i+1][j] - sum[i][j];
			}
		}

		for ( int i = 0 ; i < m ; i++ ) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int result = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];
			
			System.out.println(result);
		}
		br.close();
    }
}