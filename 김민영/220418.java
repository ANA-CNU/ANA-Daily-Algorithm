import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		char[] alphabet=new char[26];
		int[] count=new int[26];
		for(int i=0;i<26;i++) {
			alphabet[i]=(char)((char)i+'a');
		}
		for(int i=0;i<word.length();i++) {
			for(int j=0;j<26;j++) {
				if(word.charAt(i)==alphabet[j]) {
				count[j]++;
				}
			}
			
		}
		for(int i=0;i<26;i++) {
			System.out.printf("%d ",count[i]);
		}

	}

}
