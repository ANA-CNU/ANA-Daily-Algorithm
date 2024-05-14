package baekjoon;
import java.util.*;
public class n1245 {
	static int N;
	static int M;
	static int[][] arr1 = new int[102][72];
	static boolean[][] visited = new boolean[102][72];
	static boolean bfs(int i, int j) {
		if(visited[i][j]) {
			return false;
		}
		Queue<Integer> que = new LinkedList<>();
		que.offer(i);
		que.offer(j);
		while(!que.isEmpty()) {
			int here_x = que.poll();
			int here_y = que.poll();
			if(arr1[here_x][here_y]<arr1[here_x+1][here_y+1] || arr1[here_x][here_y]<arr1[here_x][here_y+1] || arr1[here_x][here_y]<arr1[here_x-1][here_y+1]
			|| arr1[here_x][here_y]<arr1[here_x+1][here_y] || arr1[here_x][here_y]<arr1[here_x][here_y] || arr1[here_x][here_y]<arr1[here_x-1][here_y]
			|| arr1[here_x][here_y]<arr1[here_x+1][here_y-1] || arr1[here_x][here_y]<arr1[here_x][here_y-1] || arr1[here_x][here_y]<arr1[here_x-1][here_y-1]) {
				return false;
			}
			if(arr1[here_x+1][here_y+1]==arr1[here_x][here_y] && !visited[here_x+1][here_y+1]) {
				int there_x = here_x+1;
				int there_y = here_y+1;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x][here_y+1]==arr1[here_x][here_y] && !visited[here_x][here_y+1]) {
				int there_x = here_x;
				int there_y = here_y+1;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x-1][here_y+1]==arr1[here_x][here_y] && !visited[here_x-1][here_y+1]) {
				int there_x = here_x-1;
				int there_y = here_y+1;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x+1][here_y]==arr1[here_x][here_y] && !visited[here_x+1][here_y]) {
				int there_x = here_x+1;
				int there_y = here_y;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x][here_y]==arr1[here_x][here_y] && !visited[here_x][here_y]) {
				int there_x = here_x;
				int there_y = here_y;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x-1][here_y]==arr1[here_x][here_y] && !visited[here_x-1][here_y]) {
				int there_x = here_x-1;
				int there_y = here_y;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x+1][here_y-1]==arr1[here_x][here_y] && !visited[here_x+1][here_y-1]) {
				int there_x = here_x+1;
				int there_y = here_y-1;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x][here_y-1]==arr1[here_x][here_y] && !visited[here_x][here_y-1]) {
				int there_x = here_x;
				int there_y = here_y-1;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
			if(arr1[here_x-1][here_y-1]==arr1[here_x][here_y] && !visited[here_x-1][here_y-1]) {
				int there_x = here_x-1;
				int there_y = here_y-1;
				que.offer(there_x);
				que.offer(there_y);
				visited[there_x][there_y] = true;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 1 ; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		int result = 0;
		for(int i = 1 ; i<=N; i++) {
			for(int j = 1; j<=M; j++) {
				if(bfs(i,j)) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}
