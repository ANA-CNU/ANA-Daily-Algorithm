import java.io.*;
import java.util.*;

public class Main {
	static int m = 0;
	static int[] selected;
	static boolean[] visited;
	static int z = 0;
	static int[] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void search(int n) throws IOException {
		if (n > m) {
			for (int i = 1; i <= m; i++)
				bw.write(selected[i] + " ");
			bw.write("\n");
		} else {
			for (int i = 0; i < z; i++) {
				if(selected[n-1]<=num[i]) {
					selected[n] = num[i];
					search(n + 1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
		StringTokenizer b = new StringTokenizer(br.readLine(), " ");

		num = new int[Integer.parseInt(ss.nextToken())];
		boolean[] booleanNum = new boolean[10001];

		int count = 0;

		while (count < num.length) {
			int cmp = Integer.parseInt(b.nextToken());

			if (!booleanNum[cmp]) {
				num[z++] = cmp;
				booleanNum[cmp] = true;
			}

			count++;
		}

		m = Integer.parseInt(ss.nextToken());

		selected = new int[m+1];
		visited = new boolean[z];

		Arrays.sort(num, 0, z);
		search(1);
		bw.flush();
	}
}