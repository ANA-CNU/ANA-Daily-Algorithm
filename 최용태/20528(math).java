import java.util.Scanner;


public class Main{ 	
	
	public static class Pelindrom{
		private static Scanner sc=new Scanner(System.in);
		private int N=sc.nextInt();
		private char[] charArray;
		public String str;
		public Pelindrom() {}
		
		public void run() {
			int mid;
			int flag1=0;
			char prevChar='0';
			for(int i=0;i<N;i++) {
				str=sc.next();
				charArray=str.toCharArray();
				
				if(i>0 && prevChar!=charArray[0])
					flag1=1;
				
				mid=(str.length())/2;
				
				for(int j=0;j<mid;j++) {
					if(charArray[j]==charArray[str.length()-j-1])
						continue;
					else {
						flag1=1;
						break;
					}
				}
				prevChar=charArray[0];
			}
			
			if(flag1==1)
				System.out.println(0);
			else
				System.out.println(1);
			
		}
	
   
	}
	 public static void main(String[] args){
	    	Pelindrom Pelin=new Pelindrom();
	    	Pelin.run();

	    }
}