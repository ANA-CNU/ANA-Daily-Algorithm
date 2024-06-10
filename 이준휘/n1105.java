package baekjoon2024June;
import java.util.Scanner;
public class n1105 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		String str1 = ""+l;
		String str2 = ""+r;
		int num = 0;
		if(str1.length() != str2.length()) {
			System.out.println("0");
			return;
		}
		for(int i = 0; i< str1.length(); i++) {
			if(str1.charAt(i) == str2.charAt(i)) {
				if(str1.charAt(i) == '8') {
					num++;
				}
			}
			else break;
		}
		System.out.println(num);
	}
}
