import java.io.*;
import java.util.*;

public class Main {
	static int upperBound(int[] num,int a,  int t){
	    int lo = -1;
	    int hi = num.length;
	    while(lo + 1 < hi){
	        int mid = (lo + hi) / 2;
	        if(num[mid] + a > t ){
	            hi = mid;
	        }else{
	            lo = mid;
	        }
	    }
	    return hi;
	}
	static int lowerBound(int[] num,int a ,int t){
	    int lo = -1;
	    int hi = num.length;
	    while(lo + 1 < hi){
	        int mid = (lo + hi) / 2;
	        if(num[mid] + a >= t ){
	            hi = mid;
	        }else{
	            lo = mid;
	        }
	    }
	    return hi;
	}
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.
		readLine());
		int[] A = new int[n+1];
		for(int i = 1; i <= n; i++){
		    A[i] = A[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.
		readLine());
		int[] B = new int[m+1];
		for(int i = 1; i <= m; i++){
		    B[i] = B[i-1] + Integer.parseInt(st.nextToken());
		}
		int[] sumA = new int[n*(n+1)/2];
		int index = 0;
		for(int i = 1; i <= n; i++){
		    for(int j = 0; j <= n-i; j ++){
		        sumA[index] = A[j+i] -A[j];
		        index++;
		    }
		}
		
		int[] sumB = new int[m*(m+1)/2];
		index = 0;
		for(int i = 1; i <= m; i++){
		    for(int j = 0; j <= m-i; j ++){
		        sumB[index] = B[j+i] -B[j];
		        index++;
		    }
		}
		Arrays.sort(sumB);
		long cnt = 0;
		for(int i = 0; i < sumA.length; i++){
		    cnt += upperBound(sumB,sumA[i],T) - lowerBound(sumB, sumA[i],T);
		}
		bw.write(Long.toString(cnt));
		bw.flush();
		bw.close();
		br.close();
	} 
}