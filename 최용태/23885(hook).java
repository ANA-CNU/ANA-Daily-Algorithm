import java.util.Scanner;

public class Main {
	
	public static class Loc{
		public int x;
		public int y;
		
		public Loc(int a,int b) {
			x=a;
			y=b;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		Loc start=new Loc(sc.nextInt(),sc.nextInt());
		Loc end=new Loc(sc.nextInt(),sc.nextInt());
		
		int resultx=start.x-end.x;
		int resulty=start.y-end.y;
		
		if(resultx<0)
			resultx*=-1;
		if(resulty<0)
			resulty*=-1;
		
	
		
		if(N==1) {
			if(resulty==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else if(M==1) {
			if(resultx==0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		else if((resultx%2!=0 && resulty%2!=0)||(resultx%2==0 && resulty%2==0))
			System.out.println("YES");
		else
			System.out.println("NO");
		
	}
}