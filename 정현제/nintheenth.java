package grap_my_hand;

import java.util.Scanner;
import java.util.Stack;

public class nintheenth {

	static void print(Stack st) {
		while (!st.empty()) {
			System.out.print(st.peek());
			st.pop();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack st = new Stack();

		String s = sc.nextLine();
		boolean check = false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				print(st); // <를 만나면 여태껏 저장해둔 문자열 거꾸로 출력
				check = true;
				System.out.print(s.charAt(i));
			} else if (s.charAt(i) == '>') {
				check = false;
				System.out.print(s.charAt(i));
			} else if (check) {
				System.out.print(s.charAt(i));
			}

			else {
				if (s.charAt(i) == ' ') {
					print(st);
					System.out.print(s.charAt(i));
				}

				else {
					st.push(s.charAt(i));
				}
			}

		}

		print(st);

	}

}