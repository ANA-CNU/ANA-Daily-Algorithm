import java.util.Arrays;
import java.util.Scanner;

public class Q_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int[] arr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			int a = (int) str.charAt(i);
			if (a >= 97 && a <= 122) {
				a -= 97;
			} else if (a >= 65 && a <= 90) {
				a -= 65;
			}
			arr[a]++;
		}
		int max = arr[0];
		for(int n :arr) {
			if(n>max) {max=n;}
		}
		int count=0;
		for(int n : arr) {
			if(n==max) {
				count++;
			}
		}
		if(count>1) {
			System.out.println("?");
		} else if(count==1) {
			for(int i=0; i<arr.length; i++) {if(arr[i]==max) {
				System.out.println((char)(i+65));}}
		}
	}

}
