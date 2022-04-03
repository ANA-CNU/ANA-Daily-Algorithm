import java.util.Scanner;

public class Main{
   static Arr[] newlist=new Arr[100000];
	public static class Arr{
		int age;
		String name;
		public Arr(int a,String b) {
			age=a;
			name=b;
		}
	}
	public static void merge(Arr[] arr,int left,int mid,int right) {
		int i=left,j=mid+1,k=left,l=0;

		while(i<=mid && j<right+1) {
			if(arr[i].age <= arr[j].age)
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
	public static void parted(Arr[] arr,int left,int right) {
		int mid;
		if(left<right) {
			mid=(left+right)/2;
			parted(arr,left,mid);
			parted(arr,mid+1,right);
			merge(arr,left,mid,right);
		}
		
	}
	
    public static void main(String[] args){       
       Scanner sc=new Scanner(System.in);
    	int N=sc.nextInt();
    	Arr[] arr=new Arr[N];
    	
    	for(int i=0;i<N;i++) {
    		int a=sc.nextInt();
    		String b=sc.next();
    		arr[i]=new Arr(a,b);
    	}
    		
    	parted(arr,0,N-1);
    	
    	for(int i=0;i<N;i++)
    		System.out.println(arr[i].age+" "+arr[i].name);
    }
 }