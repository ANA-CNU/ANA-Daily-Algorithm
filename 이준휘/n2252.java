package baekjoon2024June;
import java.util.*; 
public class n2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] arr = new boolean[n+1][n+1];
		boolean[] front = new boolean[n+1];
		int[] num = new int[n+1];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = true;
			front[b] = true;
			num[b]++;
		}
		boolean[] visited = new boolean[n+1];
		for(int i = 1; i<=n; i++) {
			if(!front[i]) {
				Queue<Integer> que = new LinkedList<>();
				que.offer(i);
				while(!que.isEmpty()) {
					int here = que.poll();
					System.out.print(here + " ");
					visited[here] = true;
					for(int j = 1; j<=n; j++) {
						if(arr[here][j]) {
							arr[here][j] = false;
							num[j]--;
						}
					}
					for(int j = 1; j<=n; j++) {
						if( num[j] == 0 && front[j] && !visited[j]) {
							
							que.offer(j);
						}
					}
				}
			}
		}
		
		
	}
}
