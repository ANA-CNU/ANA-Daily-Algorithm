package 여러가지풀어보기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class P5430_AC {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			int[] number = new int[n];
			String s = br.readLine();
			String num =s.substring(1,s.length()-1);
			StringTokenizer st = new StringTokenizer(num,",");
			
			for(int i = 0; i < n; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}

			int head = 0;
			int tail = n;
				
			boolean isHead = true;
			for (int i = 0; i < p.length(); i++) {
				char a = p.charAt(i);
				if(a == 'R') {
					if(isHead) {
						isHead = false;
					}else {
						isHead = true;
					}
				}else if(a == 'D') {
					if(isHead) {
						head++;
					}else {
						tail--;
					}
				}
			}
			if(head > tail) {
				bw.write("error\n");
			}else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				if(isHead) {
					for(int i = head; i < tail; i++) {
						sb.append(number[i]);
						if(i == tail-1)continue;
						sb.append(",");
					}
				}else {
					for(int i = tail - 1; i >= head; i--) {
						sb.append(number[i]);
						if(i == head)continue;
						sb.append(",");
					}
				}
				
				sb.append("]\n");
				bw.write(sb.toString());
			}
		}
		bw.flush();
	}

}
