import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String word=sc.nextLine();
		char[] wa=word.toCharArray();
		int result=0,realResult=0;
		for(int i=0;i<wa.length;i++) {
			if((int)wa[i]<97) {
				result=result+(int)wa[i]-38;
			}
			else {
				result=result+(int)wa[i]-96;
			}
		}
		
		for(int k=2;k<result;k++) {
			if(result%k==0) {
				realResult=1;
				break;
			}
		}
		if(realResult==1) {
			System.out.println("It is not a prime word.");
		}
		else {
			System.out.println("It is a prime word.");
		}

	}

}
