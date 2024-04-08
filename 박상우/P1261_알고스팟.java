package ¿ÏÀüÅ½»ö;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261_¾Ë°í½ºÆÌ {
	static int N,M,result;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1 ,1 , 0, 0};
	static int[] dy = {0, 0 , -1, 1};
	public static void bfs() {
		visited[0][0] = true;
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a0, int[] a1) {
				return a0[2] - a1[2];
			}
		});
		q.add(new int[] {0,0,0});
		while(!q.isEmpty()) {
			int[] now = q.remove();
			if(now[0] == M-1 && now[1] == N-1) {
				result = now[2];
				return;
			}
			for(int i = 0; i < 4; i++) {
				if(now[0] + dx[i] < 0 || now[0] + dx[i] >= M || now[1] + dy[i] < 0 || now[1] + dy[i] >= N || visited[now[0] + dx[i]][now[1] + dy[i]]) continue;
				visited[now[0] + dx[i]][now[1] + dy[i]] = true;
				if(map[now[0] + dx[i]][now[1] + dy[i]] == 0) {
					q.add(new int[] {now[0] + dx[i] , now[1] + dy[i], now[2]});
				}else {
					q.add(new int[] {now[0] + dx[i] , now[1] + dy[i], now[2] + 1});
				}
			}
			
		}
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visited = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			String s = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		bfs();
		bw.write(Integer.toString(result));
		bw.flush();
		bw.close();
		br.close();
	}

}
