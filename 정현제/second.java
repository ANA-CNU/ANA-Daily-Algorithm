package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class second {

	public static int[] que;
	public static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int total = Integer.parseInt(br.readLine());

		que = new int[total];

		while(total --> 0) {

			st = new StringTokenizer(br.readLine()," ");

			switch(st.nextToken()) {

			case "push":
				push(Integer.parseInt(st.nextToken()));
				break;

			case "pop":
				sb.append(pop()).append('\n');
				break;

			case "size":
				sb.append(size()).append('\n');
				break;

			case "empty":
				sb.append(empty()).append('\n');
				break;

			case "front":
				sb.append(front()).append('\n');
				break;

			case "back":
				sb.append(back()).append('\n');
				break;
			}
		}
		System.out.println(sb);


	}



	public static void push(int num) {
		que[size]=num;
		size++;
	}
	public static int pop() {
		if(size==0) {
			return -1;
		}
		else {
			int front=que[0];
			for(int i=0;i<size;i++) {
				que[i]=que[i+1];
			}
			size=size-1;
			return front;
		}
	}
	public static int size() {
		return size;
	}
	public static int empty() {
		if(size==0) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static int back() {
		if(size!=0) {
			return que[size-1];
		}
		else {
			return -1;
		}
	}
	public static int front() {
		if(size!=0) {
			return que[0];
		}
		else {
			return -1;
		}
	}
}
