import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String line=sc.nextLine();
		char[] word=line.toCharArray();
		int k=line.length(),countOf0=0,countOf1=0;
		for(int i=0;i<line.length();i=i+k) {
			if(word[i]=='0') {
				for(int j=0;j<line.length()-i;j++) {
					if(word[i+j]!='0') {
						countOf0++;
						k=j;
						break;
					}
				}
			}
			if(word[i]=='1') {
				for(int j=0;j<line.length()-i;j++) {
					if(word[i+j]!='1') {
						countOf1++;
						k=j;
						break;
					}
				}
			}
			
		}
		if(word[line.length()-1]=='0') {
			countOf0++;
		}
		else if(word[line.length()-1]=='1') {
			countOf1++;
		}
		if(countOf0<=countOf1) {
			System.out.println(countOf0);
		    }
		else if(countOf0>countOf1){
			System.out.println(countOf1);
		    }
	}
}
