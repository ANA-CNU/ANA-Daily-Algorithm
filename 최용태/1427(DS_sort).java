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
			if(arr[i] >= arr[j])
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
       	String a=sc.next();
    	int[] arr=new int[a.length()];
    	
    	for(int i=0;i<a.length();i++) {
    		char b=a.charAt(i);
    		arr[i]=Character.getNumericValue(b);
    	}
 
    		
    	parted(arr,0,a.length()-1);
    	for(int i=0;i<a.length();i++)
    		System.out.print(arr[i]);
    	

    }
 }