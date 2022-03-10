package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class ninth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int total = Integer.parseInt(br.readLine());


		for(int i=0;i<total;i++) {

			Stack<Character> stack1 = new Stack<Character>();
			Stack<Character> stack2 = new Stack<Character>();

			char[] str = br.readLine().toCharArray();

			for(int j=0; j<str.length; j++) {
				switch(str[j]) {

				case '<':
					if(!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
					break;
				case '>':
					if(!stack2.isEmpty()) {
						stack1.push(stack2.pop());
					}
					break;
				case '-':
					if(!stack1.isEmpty()) {
						stack1.pop();
					}
					break;
				default:
					if(str[j] != '<' && str[j] != '>' && str[j] != '-') {
						stack1.push(str[j]);
					}
					break;
				} 
			}

			while(!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			StringBuilder sb = new StringBuilder();

			for(int j=0; j<stack1.size(); j++) {
				sb.append(stack1.elementAt(j));
			}

			System.out.println(sb);
		}
	}
}