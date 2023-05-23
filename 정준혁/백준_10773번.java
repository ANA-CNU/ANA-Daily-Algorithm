package bj;

import java.util.Scanner;
import java.util.Stack;

public class 백준_10773번 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a == 0) {
				stack.pop();
				continue;
			}
			stack.push(a);
		}
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
