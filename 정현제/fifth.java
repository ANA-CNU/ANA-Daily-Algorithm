package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class fifth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String word = br.readLine();
		int num = Integer.parseInt(br.readLine());

		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();

		for(int i=0;i<word.length();i++) {
			stack1.push(word.charAt(i));
		}

		for(int i=0;i<num;i++) {
			st = new StringTokenizer(br.readLine()," ");
			String str1 = st.nextToken();
			if(str1.equals("P")) {
				String str2 = st.nextToken();
				stack1.push(str2.charAt(0));
			}
			else if(str1.equals("L")) {
				if(stack1.size()!=0) {
					stack2.push(stack1.pop());
				}
			}
			else if(str1.equals("D")) {
				if(stack2.size()!=0) {
					stack1.push(stack2.pop());
				}
			}
			else {
				if(stack1.size()!=0) {
					stack1.pop();
				}
			}

		}
		while(stack1.size()!=0) {
			char w = stack1.pop();
			stack2.push(w);
		}
		StringBuilder sb = new StringBuilder();

		while(stack2.size()!=0) {
			sb.append(stack2.pop());
		}
		System.out.println(sb);

	}

}
