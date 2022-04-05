import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a,b,money=0;
		for(int i=0;i<n;i++) {
			a=sc.nextInt();
		    b=sc.nextInt();
		    if(a==1) {
		    	money=5000000;
		    	}
			else if(a>=2&&a<=3) {
				money=3000000;
			}
			else if(a>=4&&a<=6) {
				money=2000000;
			}
			else if(a>=7&&a<=10) {
				money=500000;
			}
			else if(a>=11&&a<=15) {
				money=300000;
			}
			else if(a>=16&&a<=21){
				money=100000;
			}
			if(b==1) {
				money=money+5120000;
			}
			else if(b>=2&&b<=3) {
				money=money+2560000;
			}
			else if(b>=4&&b<=7) {
				money=money+1280000;
			}
			else if(b>=8&&b<=15) {
				money=money+640000;
			}
			else if(b>=16&&b<=31){
				money=money+320000;
			}
			System.out.println(money);
			money=0;
			}
    }

}
