package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class third {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		st = new StringTokenizer(br.readLine()," ");

		int total=Integer.parseInt(st.nextToken());
		int delete=Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();

		for(int i=1;i<total+1;i++) {
			q.add(i);
		}

		int[] answer=new int[total];

		int outnum=0;
		int count=0;
		int size=q.size();

		while(size-- > 0) {
			for(int i=0; i<delete-1;i++) {
				outnum=q.poll();
				q.add(outnum);
			}	
			outnum=q.poll();
			answer[count]=outnum;
			count++;
		}
		for(int i=0;i<answer.length-1;i++) {
			sb.append(answer[i]).append(", ");
		}
		System.out.println("<"+sb+answer[(int) (answer.length-1l)]+">");

	}

}
