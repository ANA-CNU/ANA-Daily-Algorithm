package baekjoon;
import java.util.*;
public class n1725 {
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] height = new int[N+2];
		long answer = 0;
		Stack<Integer> stack = new Stack<>();
		height[0] = 0;
		height[N] = 0;
		for(int i = 1; i<=N; i++) {
			height[i] = sc.nextInt();
		}
		stack.push(0);
		for(int i = 1; i<=N+1; i++) {
			while(!stack.isEmpty()) {
				int top = stack.peek();
				if(height[top] <= height[i]) {
					break;
				}
				stack.pop();
				answer = Math.max(answer, height[top] * (i-stack.peek()-1));
			}
			stack.push(i);
		}
		System.out.println(answer);
	}
}
