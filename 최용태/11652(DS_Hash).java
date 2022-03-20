import java.util.Scanner;

public class Main {
	public static class NumandIndex{
		public int _count=0;
		public long _value=0;
		public NumandIndex(){
			this._count=0;
			this._value=0;
		}
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		final int MAX_SIZE=100000;
		NumandIndex [] Array=new NumandIndex[MAX_SIZE];
		int nextIndex=0;
		int N=sc.nextInt();
		int largest=0;
		
		for(int i=0;i<MAX_SIZE;i++)
			Array[i]=new NumandIndex();
		
		for(int i=0;i<N;i++) {
			long currentNum=sc.nextLong();
			
			if(currentNum<0) {
				nextIndex=(int)(currentNum*(-1)%MAX_SIZE);
			}
			else
				nextIndex=(int)(currentNum%MAX_SIZE);
				
			do {
			if(Array[nextIndex]._count!=0 &&Array[nextIndex]._value!=currentNum) {
				nextIndex=(nextIndex+1) % MAX_SIZE;
				System.out.println("nextindex+1: "+nextIndex);	
				continue;
			}
			else {
				Array[nextIndex]._value=currentNum;
				Array[nextIndex]._count++;		
				if(nextIndex==largest)
					break;
				else {
				if(Array[nextIndex]._count>=Array[largest]._count) {
					if(Array[nextIndex]._count==Array[largest]._count) {
					if(Array[nextIndex]._value<Array[largest]._value)
						largest=nextIndex;
					}
					else
						largest=nextIndex;
				}
				}	
			}
			break;
			}while(true);
		}
		System.out.println(Array[largest]._value);
		
		
	}

}
