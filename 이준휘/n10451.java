package baekjoon2024June;
import java.util.*;
public class n10451 {
	static int dfs(int n, int[] arr, boolean[] visited) {
		int num=0;
		for(int i = 1; i<=n ; i++) {
			if(!visited[i]) {
				num++;
				Queue<Integer> que = new LinkedList<>();
				que.offer(i);
				while(!que.isEmpty()) {
					int here = arr[que.poll()];
					if(!visited[here]) {
						visited[here] = true;
						que.offer(here);
					}
				}
			}
		}
		return num;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i<t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			boolean[] visited = new boolean[n+1];
			for(int j = 1; j<=n; j++) {
				arr[j] = sc.nextInt();
			}
			System.out.println(dfs(n, arr, visited));
		}
	}
}
