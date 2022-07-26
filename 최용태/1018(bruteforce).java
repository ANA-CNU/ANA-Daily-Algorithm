import java.io.*;
import java.util.*;

public class Main {
	public static final int RANGE = 8;

	public static int search(int firstLine, int startIdx, char[][] chess) {
		int count = 65;
		char[] BW = { 'B', 'W' };
		int BWidx = 0;

		for (int repeat = 0; repeat < 2; repeat++) {
			int current=0;
			for (int i = firstLine; i < firstLine + RANGE; i++) {
				for (int j = startIdx; j < startIdx + RANGE; j++) {
					if (chess[i][j] != BW[BWidx % 2]) {
						current++;
					}
					BWidx++;
				}
				BWidx++;
			}
			BWidx = 1;
			if(current<count)
				count=current;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		int least = 65;
		char[][] chess = new char[N][];

		for (int i = 0; i < N; i++) {
			chess[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			int current = 0;
			for (int j = 0; j < M; j++) {
				if (i + RANGE <= N && j + RANGE <= M) {
					current = search(i, j, chess);
					System.out.println(current);
					if (current < least)
						least = current;
				}
			}
		}

		System.out.println(least);
	}
}