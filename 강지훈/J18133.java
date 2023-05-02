import java.io.*;
import java.util.*;

public class J18133 {
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static Stack<Integer> stack = new Stack<Integer>();
	public static boolean visited[] = new boolean[100001];

	public static ArrayList<ArrayList<Integer>> rev = new ArrayList<ArrayList<Integer>>();
	public static int components[] = new int[100001];
	public static int V = 0;

	public static void setStack(int cur) {
		visited[cur] = true;

		for (int next : rev.get(cur)) {
			if (visited[next]) continue;
			
			setStack(next);
		}

		stack.push(cur);
	}

	public static void dfs(int cur) {
		components[cur] = V;

		for (int next : adj.get(cur)) {
			if (components[next] != -1) continue;

			dfs(next);
		}
	}

	public static void setComponents() {
		while (!stack.empty()) {
			int cur = stack.pop();
			if (components[cur] != -1) continue;

			dfs(cur);
			++V;
		}
	}

	public static int setSCC(int N) {
		boolean indegree[] = new boolean[V];
		for (int i = 0; i < V; i++) indegree[i] = false;

		for (int i = 1; i < N + 1; i++) {
			int u = components[i];

			for (int j : adj.get(i)) {
				int v = components[j];

				if (u == v) continue;
				indegree[v] = true;
			}
		}

		int ans = 0;
		for (int i = 0; i < V; i++) {
			if (!indegree[i]) ++ans;
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N + 1; i++) {
			adj.add(new ArrayList<Integer>());
			rev.add(new ArrayList<Integer>());
			components[i] = -1;
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

			adj.get(u).add(v);
			rev.get(v).add(u);
		}

		for (int i = 1; i < N + 1; i++) {
			if (visited[i]) continue;
			setStack(i);
		}

		setComponents();

		System.out.println(setSCC(N));
	}
}
