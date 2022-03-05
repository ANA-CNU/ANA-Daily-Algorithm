package grap_my_hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class forth {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String word = br.readLine();

		Stack<String> stack = new Stack<String>();

		int total=word.length();
		int stackcount=0;
		
		for(int i=0; i<total;i++) {
			if(word.charAt(i)=='('){
				stack.push("(");
			}
			else {
				stack.pop();
				
				if(word.charAt(i-1)=='(') {
					stackcount=stackcount+stack.size();
				}
				else {
					stackcount+=1;
				}
			}
		}
		System.out.println(stackcount);
	}

}
