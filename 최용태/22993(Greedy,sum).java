import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 누적합과 정렬을 이용한 풀이
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] a = new long[N];
		boolean YES = true;
		long[] p = new long[N + 1];
		String num = br.readLine();
		StringTokenizer anum = new StringTokenizer(num, " ");

		for (int i = 0; i < N; i++) {
			a[i] = Long.parseLong(anum.nextToken());
		}
		if (a.length > 1) {
			Arrays.sort(a, 1, N);
			for (int i = 0; i < N; i++) {
				p[i + 1] = p[i] + a[i];
			}
			if (a[0] > a[1]) {
				for (int i = 1; i < N; i++) {
					if (p[i] <= a[i]) {
						YES=false;
						break;
					}
				}
			}else {
				YES=false;
			}
		}
		
		if (YES)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}