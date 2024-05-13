package baekjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class n1697 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		if(N > K) {
			System.out.println(N-K);
			return;
		}
		Queue<Integer> que = new LinkedList<>();
		que.offer(N);
		int[] time = new int[10000001];
		int result=0;
		boolean[] visited =  new boolean[10000001];
		visited[N]=true;
		while(!que.isEmpty()) {
			int here = que.poll();
			
			if(here == K) {
				break;
			}
			if(here*2 <=100000 && !visited[here*2]) {
				int there = here*2;
				que.offer(there);
				visited[there]=true;
				time[there]= time[here]+1;
			}
			if(here+1 < 100000 && !visited[here+1]) {
				int there = here+1;
				que.offer(there);
				visited[there]=true;
				time[there]= time[here]+1;
			}
			if(here-1 >=0 && !visited[here-1]) {
				int there = here-1;
				que.offer(there);
				visited[there]=true;
				time[there]= time[here]+1;
			}
		}
		System.out.println(time[K]);
	}
}
