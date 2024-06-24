package baekjoon2024June;
import java.util.*;
public class n2331 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] visited = new int[10000];
		Queue<Integer> que = new LinkedList<>();
		int n = sc.nextInt();
		que.offer(n);
		int m = sc.nextInt();
		while(!que.isEmpty()) {
			int k = que.poll();
			String str = "" + k;
			int sum = 0;
			for(int i = 0; i<str.length(); i++) {
				String c = ""+str.charAt(i);
				sum += Math.pow(Integer.valueOf(c), m);
				
			}
			if(visited[sum] == 0) {
				que.offer(sum);
				visited[sum] = visited[k] +1;
			}
			else {
				if(k == n)
				System.out.println(0);
				else {
					System.out.println(visited[sum]);
				}
			}
		}
	}
}
