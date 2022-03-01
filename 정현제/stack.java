package grap_my_hand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class stack {

	public static int[] stack;
	public static int size = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();


		StringTokenizer st;

		int total = Integer.parseInt(br.readLine());

		stack = new int[total];

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

			case "top":
				sb.append(top()).append('\n');
				break;
			}
		}
		System.out.println(sb);
	}
	public static void push(int num){
		stack[size]=num;
		size++;
	}
	public static int pop(){
		if(size==0) {
			return -1;
		}
		else {
			int out=stack[size-1];
			stack[size-1]=0;
			size=size-1;
			return out;	
		}
	}
	public static int size() {
		return size;
	}
	public static int empty() {
		if(size!=0) {
			return 0;
		}
		else {
			return 1;
		}
	}
	public static int top() {
		if(size!=0) {
			return stack[size-1];
		}
		else {
			return -1;
		}

	}
}


