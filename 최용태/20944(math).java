import java.util.Scanner;


public class Main{ 	
	
	public static class Pelindrom{
		private static Scanner sc=new Scanner(System.in);
		private int N=sc.nextInt();
		private char[] charArray= {'a','b','c'};
		private char[] PArray=new char[N];
		public Pelindrom() {}
		
		public void run() {
			if(N==1)
				System.out.print(charArray[randomNum()]);
			else {
			int mid;
			mid=N/2; // if 5, mid==2
			for(int i=0;i<=mid/2;i++) {
				char currentChar=charArray[randomNum()];
				PArray[i]=currentChar;
				PArray[mid-i-1]=currentChar;
			}
			
			if(N%2!=0) {
				PArray[mid]=charArray[randomNum()];
				mid++;
			}
			for(int i=0;i<mid;i++)
				PArray[N-i-1]=PArray[i];

			String str=new String(PArray);
				System.out.print(str);
			}
		}
		
		private int randomNum() {
			int _randomNum=(int)(Math.random()*3);
			return _randomNum;
		}
}
	
    public static void main(String[] args){
    	Pelindrom Pelin=new Pelindrom();
    	Pelin.run();
    }
}
 	  