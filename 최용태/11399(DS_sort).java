import java.util.Scanner;

public class Main{
	static int[] newlist=new int[1000];
	public static void parted(int[] arr,int left,int right) {
		int mid;
		if(left<right) {
			mid=(left+right)/2;
			parted(arr,left,mid);
			parted(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
	}
	
	public static void merge(int[] arr,int left,int mid,int right) {
		int i=left,j=mid+1,k=left,l=0;

		while(i<=mid && j<=right) {
			if(arr[i] <= arr[j])
				newlist[k++]=arr[i++];
			else
				newlist[k++]=arr[j++];
		}
		
		if(i>mid) {
			for(l=j;l<=right;l++)
				newlist[k++]=arr[l];
		}
		else{
			for(l=i;l<=mid;l++)
				newlist[k++]=arr[l];
		}
		
		for(l=left;l<=right;l++)
			arr[l]=newlist[l];
	}
	
	
    public static void main(String[] args){       
       Scanner sc=new Scanner(System.in);
    	int N=sc.nextInt();
    	int[] arr=new int[N];
    	int result=0;
    	int finalResult=0;
    	for(int i=0;i<N;i++) {
    		int a=sc.nextInt();
    		arr[i]=a;
    		result+=arr[i];
    	}
 
    		
    	parted(arr,0,N-1);
    	
    	for(int i=N-1;i>-1;i--) {
    		finalResult+=result;
    		result-=arr[i];
    	}
    	System.out.println(finalResult);
    	
    }
 }