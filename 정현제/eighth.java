package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class eighth {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String sentence = br.readLine();
		
		int sum=0;
		int answer=1;
		
		boolean what=true;
		
		Stack<Character> s = new Stack<Character>();

		for(int i=0;i<sentence.length();i++) {
			char cur = sentence.charAt(i);
			if(cur=='('){
				answer*=2;
				s.push(cur);
			}
			else if(cur=='['){
				answer*=3;
				s.add(cur);
			}
			else if(cur==')'){
				if(s.isEmpty() || s.peek()!='(') {
					what=false;
					break;
				}
				if(sentence.charAt(i-1)=='(') {
					sum+=answer;
				}
				s.pop();
				answer/=2;
			}
			else if(cur==']') {
				if(s.isEmpty() || s.peek()!='[') {
					what=false;
					break;
				}
				if(sentence.charAt(i-1)=='[') {
					sum+=answer;
				}
				s.pop();
				answer/=3;
			}
			else {
				what=false;
				break;
			}
		}
		if(!s.isEmpty() || !what) {
			System.out.println(0);
		}
		else {
			System.out.println(sum);
		}
	}
	
}
