import java.io.*;
import java.util.*;

public class J11003 {
	static class Struct {
		int n, i;
	
		public Struct(int n, int i) {
			this.n = n;
			this.i = i;
		}
	}

	static Deque<Struct> dq = new ArrayDeque<Struct>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			while (!dq.isEmpty()) {
				Struct cur = dq.peekLast();
				int curn = cur.n;

				if (n > curn) break;

				dq.pollLast();
			}

			dq.add(new Struct(n, i));
			
			while (!dq.isEmpty()) {
				Struct cur = dq.peek();
				int curi = cur.i;

				if (i - L < curi) break;

				dq.poll();
			}

			sb.append(dq.peek().n).append(' ');
		}

		System.out.println(sb.toString());
	}
	
}

