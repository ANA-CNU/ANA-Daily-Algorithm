import java.util.Scanner;

public class Q_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arr = str.split(" ");
		int count=0;
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		int length = arr.length;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]=="") {
				count+=1;
			}
		}
		System.out.println(length-count);
	}
}
