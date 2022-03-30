import java.util.*;

public class Q_2577 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int value = sc.nextInt()*sc.nextInt()*sc.nextInt();
		String str = Integer.toString(value);
		int n0 = 0, n1 = 0, n2 = 0, n3 = 0, n4 = 0, n5 = 0, n6 = 0, n7 = 0, n8 = 0, n9 = 0;
		for (int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='0') {n0++;} else if(str.charAt(i)=='1') {n1++;}
			else if(str.charAt(i)=='2') {n2++;} else if(str.charAt(i)=='3') {n3++;}
			else if(str.charAt(i)=='4') {n4++;} else if(str.charAt(i)=='5') {n5++;}
			else if(str.charAt(i)=='6') {n6++;} else if(str.charAt(i)=='7') {n7++;}
			else if(str.charAt(i)=='8') {n8++;} else if(str.charAt(i)=='9') {n9++;}
		}
		System.out.printf("%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d\n%d",
				n0, n1, n2, n3, n4, n5, n6, n7, n8, n9);
	}

}
