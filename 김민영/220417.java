import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int l=name.length();
		String result="";
		for(int i=0;i<l;i++) {
			int tmp=(int)name.charAt(i);
			if(tmp>=65&&tmp<=90) {
				result=result+name.charAt(i);
			}
		}
		System.out.println(result);
	}

}
