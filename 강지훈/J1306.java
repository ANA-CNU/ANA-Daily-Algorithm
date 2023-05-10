import java.io.*;
import java.util.*;

public class J1306 {
	static class Struct implements Comparable<Struct> {
		int n, i;

		Struct(int n, int i) {
			this.n = n;
			this.i = i;
		}

		@Override
		public int compareTo(Struct s1) {
			return this.n < s1.n ? 1 : -1;
		}
	}

	static int ads[] = new int[1000000];
	static PriorityQueue<Struct> pq = new PriorityQueue<Struct>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * M - 1; i++) {
			int n = Integer.parseInt(st.nextToken());
			pq.add(new Struct(n, i));
		}

		sb.append(pq.peek().n).append(' ');

		for (int i = 2 * M - 1; i < N; i++) {
			while (!pq.isEmpty()) {
				Struct cur = pq.peek();
				int curi = cur.i;

				if (i - (2 * M - 1) < curi) break;

				pq.remove();
			}
			
			int n = Integer.parseInt(st.nextToken());
			pq.add(new Struct(n, i));

			sb.append(pq.peek().n).append(' ');
		}

		System.out.println(sb.toString());
	}
	
}
