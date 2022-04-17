import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word="";
		while(sc.hasNextLine()) {
			word=sc.nextLine();
			int l=word.length();
			int[] count=new int[4];
			for(int j=0;j<l;j++) {
				int tmp=(int)word.charAt(j);
				if(tmp==32) {
					count[3]++;
				}
				else if(tmp>=48&&tmp<=57) {
					count[2]++;
				}
				else if(tmp>=65&&tmp<=90) {
					count[1]++;
				}
				else {
					count[0]++;
				}
				
			}
		System.out.printf("%d %d %d %d\n",count[0],count[1],count[2],count[3]);
		}

	}
}
