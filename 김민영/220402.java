import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int L,P,V,result,num=1;
		while(true) {
			L=sc.nextInt();
			P=sc.nextInt();
			V=sc.nextInt();
			if(V==0&&V==0&&P==0) {
				break;
			}
			else if(V%P<L){
				result=(V/P)*L+V%P;
				System.out.printf("Case %d: %d\n",num,result);
				num++;
			}
			else {
				result=(V/P)*L+L;
				System.out.printf("Case %d: %d\n",num,result);
				num++;
			}
			
		}
	}

}
