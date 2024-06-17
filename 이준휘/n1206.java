package baekjoon2024June;
import java.util.Scanner;
public class n1206 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		float[] arr = new float[n];
		for(int i = 0; i<n; i++) {
			arr[i] = sc.nextFloat();
		}
		
		for(int i = 1 ; i<= 1000; i++) {
			boolean check = false;
			for(int j = 0; j<n; j++) {
				int s = (int)(arr[j] * (float)i);
				float a = s;
				float b = a+1;
				String str1 = "" + a/i;
				while(str1.length() < 5) {
					str1 +=0;
				}
				String str2 = "" + b/i;
				while(str2.length() < 5) {
					str2 +=0;
				}
				String str3 = "" + arr[j];
				while(str3.length() < 5) {
					str3 +=0;
				}
				boolean k = 
				str1.charAt(0) == str3.charAt(0) &&
			       str1.charAt(2) == str3.charAt(2) &&
				   str1.charAt(3) == str3.charAt(3) &&
				   str1.charAt(4) == str3.charAt(4);
				boolean l =
						str2.charAt(0) == str3.charAt(0) &&
					       str2.charAt(2) == str3.charAt(2) &&
						   str2.charAt(3) == str3.charAt(3) &&
						   str2.charAt(4) == str3.charAt(4);
				if(!k && !l) {
					check = true;
				}
			}
			if(!check) {
				System.out.println(i);
				return;
			}
		}
	}
}
