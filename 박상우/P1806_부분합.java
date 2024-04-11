package 완전탐색;

import java.util.*;
import java.io.*;

public class P1806_부분합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int []sum = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
		}
		int left = 0;
		int right = 1;
		int min = 987654321;
		while(left < right && right <= N) {
			int now = sum[right] - sum[left];
			if(S <= now) {
				min = Math.min(min, right - left);
				left++;
			}else {
				right++;
			}
		}
		if(min == 987654321) {
			bw.write("0");
		}else {
			bw.write(Integer.toString(min));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
