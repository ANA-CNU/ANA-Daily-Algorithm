package DFS_BFS_°ρµε;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2251_Ή°Ελ {
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static int A,B,C;
	static boolean[][][] visited;
	public static void bfs(int a, int b, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {a,b,c});
		visited[a][b][c] = true;
		while(!q.isEmpty()) {
			int[] now = q.remove();
			if(now[0] == 0) pq.add(now[2]);
			for(int i = 0; i < 6; i++) {
				int[] next = makeN(now[0], now[1], now[2], i);
				if(visited[next[0]][next[1]][next[2]]) continue;
				visited[next[0]][next[1]][next[2]] = true;
				q.add(new int[] {next[0], next[1], next[2]});
			}
			
		}
	}
	public static int[] makeN(int a, int b, int c, int x) {
		int[] num = new int[3];
		num[0] = a;
		num[1] = b;
		num[2] = c;
		if(x == 0 && num[2] != 0) {//C A
			num[0] = a + c;
			num[1] = b;
			num[2] = 0;
			if(num[0] > A) { 
				num[2] += num[0] - A;
				num[0] -= num[2];
			}
		}else if(x == 1 && num[2] != 0) {//C B
			num[0] = a;
			num[1] = b + c;
			num[2] = 0;
			if(num[1] > B) {
				num[2] += num[1] - B;
				num[1] -= num[2];
			}
		}else if(x == 2 && num[1] != 0) {// B A
			num[0] = a + b;
			num[1] = 0;
			num[2] = c;
			if(num[0] > A) {
				num[1] += num[0] - A;
				num[0] -= num[1];
			}
		}else if(x == 3 && num[1] != 0) {//B C
			num[0] = a;
			num[1] = 0;
			num[2] = c+b;
			if(num[2] > C) {
				num[1] += num[2] - C;
				num[2] -= num[1];
			}
		}else if(x == 4 && num[0] != 0) {//A B
			num[0] = 0;
			num[1] = b + a;
			num[2] = c;
			if(num[1] > B) {
				num[0] += num[1] - B;
				num[1] -= num[0];
			}
		}else if(x == 5 && num[0] != 0) {//A C
			num[0] = 0;
			num[1] = b;
			num[2] = c+a;
			if(num[2] > C) {
				num[0] += num[2] - C;
				num[2] -= num[0];
			}
		}
		return num;
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visited = new boolean[A+1][B+1][C+1];
		bfs(0,0,C);

		int size = pq.size();
		for(int i = 0; i < size; i++) {
			bw.write(Integer.toString(pq.remove())+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
