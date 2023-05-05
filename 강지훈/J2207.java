import java.io.*;
import java.util.*;

public class J2207 {
	static int N, M, V = 0;
	static ArrayList<HashSet<Integer>> adj = new ArrayList<HashSet<Integer>>();
	static ArrayList<HashSet<Integer>> rev = new ArrayList<HashSet<Integer>>();
	static Stack<Integer> stack = new Stack<Integer>();
	static int components[] = new int[20001];
	static boolean visited[] = new boolean[20001];

	static void setStack(int cur) {
		visited[cur] = true;

		for (int next : rev.get(cur)) {
			if (!visited[next]) setStack(next);
		}

		stack.push(cur);
	}

	static void setCom(int cur) {
		components[cur] = V;

		for (int next : adj.get(cur)) {
			if (components[next] == -1) setCom(next);
		}
	}

	static String solve() {
		for (int i = 1; i < M + 1; i++) {
			int i1 = M - i, i2 = M + i;

			if (components[i1] == components[i2]) return "OTL";
		}

		return "^_^";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 2 * M + 1; i++) {
			adj.add(new HashSet<Integer>());
			rev.add(new HashSet<Integer>());
			components[i] = -1;
			visited[i] = false;
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
			
			adj.get(M - u).add(M + v); adj.get(M - v).add(M + u);
			rev.get(M + v).add(M - u); rev.get(M + u).add(M - v);
		}

		for (int i = 0; i < 2 * M + 1; i++) {
			if (i != M && !visited[i]) setStack(i);
		}

		while (!stack.empty()) {
			int cur = stack.pop();
			if (components[cur] != -1) continue;

			setCom(cur);
			++V;
		}	

		System.out.println(solve());
	}
}
