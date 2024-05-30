package baekjoon;
import java.util.*;
public class n1068 {
	static int[] arr = new int[50];
	static boolean[][] vertex = new boolean[50][50];
	static boolean[] visited = new boolean[50]; 
	static int result=0;
	static void dfs(int n) {
		boolean check = false;
		//System.out.println(n);
		visited[n] = true;
		for(int i = 0; i<50; i++) {
			if(vertex[n][i] && !visited[i]) {
				visited[i] = true;
				dfs(i);
				check = true;
			}
		}
		if(!check) result++;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int top = 0;
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == -1) {
				top = i;
				continue;
			}
			vertex[arr[i]][i] = true;
			vertex[i][arr[i]] = true;
		}
		int m = sc.nextInt();
		if(m == top) {
			System.out.println(0);
			return;
		}
		for(int i = 0; i<50; i++) {
			vertex[m][i] = false;
			vertex[i][m] = false;
		}
		dfs(top);
		System.out.println(result);
	}
}
