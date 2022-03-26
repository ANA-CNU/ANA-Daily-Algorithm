import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int k=scanner.nextInt();
		for(int i=0;i<k;i++) {
			int n=scanner.nextInt();
			int result=(n-1)%12;
			if(result==0||result==8||result==10) {
				System.out.print("A\n");
			}
			if(result==1||result==3||result==11) {
				System.out.print("B\n");
			}
			if(result==2||result==4||result==6) {
				System.out.print("C\n");
			}
			if(result==5||result==7||result==9) {
				System.out.print("D\n");
			}
		}
	}
}
