package grap_my_hand;

import java.io.*;

public class twentyth {

	static int K;
	static int[] arr;
	static StringBuffer[] ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		K = Integer.parseInt(br.readLine());
		arr = new int[(int) Math.pow(2, K) - 1];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(input[i]);

		ans = new StringBuffer[K];
		for (int i = 0; i < K; i++)
			ans[i] = new StringBuffer();

		solve(0, arr.length - 1, 0);

		for (int i = 0; i < K; i++)
			bw.write(ans[i].toString() + "\n");
		bw.flush();

	}

	public static void solve(int s, int e, int floor) {

		if (floor == K)
			return;

		int m = (s + e) / 2;
		ans[floor].append(arr[m] + " ");

		solve(s, m - 1, floor + 1);
		solve(m + 1, e, floor + 1);
	}

}