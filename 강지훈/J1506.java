import java.io.*;
import java.util.*;

public class J1506 {
	public static int cost[] = new int[100];
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static ArrayList<ArrayList<Integer>> rev = new ArrayList<ArrayList<Integer>>();
	public static Stack<Integer> stack = new Stack<Integer>(); 
	public static boolean visited[] = new boolean[100];
	public static int components[] = new int[100];
	public static int V = 0;

	public static void setStack(int cur) {
		visited[cur] = true;

		for (int next : rev.get(cur)) {
			if (!visited[next]) setStack(next);
		}

		stack.push(cur);
	}

	public static void dfs(int cur) {
		components[cur] = V;

		for (int next : adj.get(cur)) {
			if (components[next] == -1) dfs(next);
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

	public static int solve(int N) {
		int minimumCost[] = new int[V];
		for (int i = 0; i < V; i++) {
			minimumCost[i] = 1000001;
		}

		for (int i = 0; i < N; i++) {
			int u = components[i];
			minimumCost[u] = Math.min(minimumCost[u], cost[i]);
		}

		int ans = 0;

		for (int i = 0; i < V; i++) {
			ans += minimumCost[i];
		}

		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			adj.add(new ArrayList<Integer>());
			rev.add(new ArrayList<Integer>());
			visited[i] = false;
			components[i] = -1;
		}
		
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());	
		}

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				if (c == '0') continue;

				adj.get(i).add(j);
				rev.get(j).add(i);
			}
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) setStack(i);
		}

		setComponents();

		System.out.println(solve(N));
	}
}
