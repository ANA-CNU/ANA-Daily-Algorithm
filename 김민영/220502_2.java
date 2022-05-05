import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		char[] alphabet= {'I','O','S','H','Z','X','N'};
		int okay=0;
		for(int i=0;i<input.length();i++) {
			for(int j=0;j<alphabet.length;j++) {
				if(input.charAt(i)==alphabet[j]) {
					okay++;
					break;
					
				}
			}
		}
		if(okay==input.length()) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		sc.close();
	}

}
