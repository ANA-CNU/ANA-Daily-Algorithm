package 자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class P1918_후위표기식 {
	static int priority(char x) {
		if(x == '+' || x == '-') {
			return 1;
		}
		if(x == '*' || x == '/') {
			return 2;
		}
		return 0;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char now = s.charAt(i);
			if('A' <= now && now <= 'Z') {
				sb.append(now);
			}else if(now == ')') {
				while(stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			}else if(now == '('){
				stack.push('(');
			}else {
				while(!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
					sb.append(stack.pop());
				}
				stack.push(now);
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
