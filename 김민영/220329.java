import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int sweet,sour;
		while(true) {
			sweet=scanner.nextInt();
			sour=scanner.nextInt();
			if(sweet==0&&sour==0) {
				break;
			}
			else if(sweet+sour==13) {
				System.out.print("Never speak again.\n");
			}
			else if(sweet>sour) {
				System.out.print("To the convention.\n");
			}
			else if(sour>sweet) {
				System.out.print("Left beehind.\n");
			}
			else {
				System.out.print("Undecided.\n");
			}
			
		}
	}
}
