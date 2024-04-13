package 완전탐색;

import java.io.*;
import java.util.*;

public class P1525_퍼즐 {
	static int[] num;
	static int[] dx;
	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	public static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(num);
		map.put(makeS(num), 0);
		while(!q.isEmpty()) {
			int[] now = q.remove();
			String s = makeS(now);
			if(s.equals("123456780")) return map.get("123456780");
			okay(now[9]);
			for(int i = 0; i < dx.length; i++) {
				//범위 계산
				int[] next = new int[10];
				for(int j = 0; j < 10; j++) {
					next[j] = now[j];
				}
				next[9] = dx[i];//0이 이동할 위치
				int tmp = next[next[9]];//0이 이동할 위치의 값 임시저장
				next[next[9]] = next[now[9]];//0이 이동할 위치에 현재의 0의 위치의 값 즉 0을 저장
				next[now[9]] = tmp;//값을 바꿈
				if(!map.containsKey(makeS(next))) {
					map.put(makeS(next), map.get(makeS(now))+1);
					q.add(next);
				}
				
			}
			
		}
		return -1;
	}
	public static void okay(int x) {
		int a = x - 3;
		int b = x + 3;
		int c = x + 1;
		int d = x - 1;
		int[] n;
		switch(x) {
		case 0:{
			n = new int[2];
			n[0] = b;
			n[1] = c;
			dx = n;
			break;
		}
		case 1:{
			n = new int[3];
			n[0] = b;
			n[1] = c;
			n[2] = d;
			dx = n;
			break;
		}
		case 2:{
			n = new int[2];
			n[0] = b;
			n[1] = d;
			dx = n;
			break;
		}
		case 3:{
			n = new int[3];
			n[0] = a;
			n[1] = b;
			n[2] = c;
			dx = n;
			break;
		}
		case 4:{
			n = new int[4];
			n[0] = a;
			n[1] = b;
			n[2] = c;
			n[3] = d;
			dx = n;
			break;
		}
		case 5:{
			n = new int[3];
			n[0] = a;
			n[1] = b;
			n[2] = d;
			dx = n;
			break;
		}
		case 6:{
			n = new int[2];
			n[0] = a;
			n[1] = c;
			dx = n;
			break;
		}
		case 7:{
			n = new int[3];
			n[0] = a;
			n[1] = c;
			n[2] = d;
			dx = n;
			break;
		}
		case 8:{
			n = new int[2];
			n[0] = a;
			n[1] = d;
			dx = n;
			break;
		}
		}
	}
	public static String makeS(int[] a) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			sb.append(a[i]);
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = new int[10];
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				num[i*3 + j] = st.nextToken().charAt(0) - '0';
				if(num[i*3 + j] == 0) num[9] = i*3 + j;
			}
		}
		bw.write(Integer.toString(bfs()));
		bw.flush();
		bw.close();
		br.close();
	}

}
