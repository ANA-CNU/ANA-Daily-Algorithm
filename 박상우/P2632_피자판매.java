import java.io.*;
import java.util.*;

public class Main {
	static int upperBound(int x, int T, int[] num){
	    int lo = -1;
	    int hi = num.length;
	    while(lo + 1 < hi){
	        int mid = lo + (hi - lo) / 2;
	        if(num[mid] + x > T ){
	            hi = mid;
	        }else{
	            lo = mid;
	        }
	    }
	    return hi;
	}
	static int lowerBound(int x, int T, int[] num){
	    int lo = -1;
	    int hi = num.length;
	    while(lo + 1 < hi){
	        int mid = lo + (hi - lo) / 2;
	        if(num[mid] + x >= T ){
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] A = new int[m];
		int[] B = new int[n];
		for(int i = 0; i < m; i++){
		    A[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < n; i++){
		    B[i] = Integer.parseInt(br.readLine());
		}
		int[] sumA = new int[m*(m-1) +2];
		int index = 1;
		for(int i = 1; i < m; i++){//개수
		    for(int j = 0; j < m; j++){//시작 인덱스
		        for(int k = j; k < j+i; k++){//j~j+i-1까지
		            if(k >= m){
		                sumA[index] += A[k-m];
		            }else{
		                sumA[index] += A[k];
		            }
		        }
		        index++;
		    }
		}
		for(int i = 0; i < m; i++){
		    sumA[index]+=A[i];
		}
		
		int[] sumB = new int[n*(n-1) +2];
		index = 1;
		for(int i = 1; i < n; i++){//개수
		    for(int j = 0; j < n; j++){//시작 인덱스
		        for(int k = j; k < j+i; k++){//j~j+i-1까지
		            if(k >= n){
		                sumB[index] += B[k-n];
		            }else{
		                sumB[index] += B[k];
		            }
		        }
		        index++;
		    }
		}
		for(int i = 0; i < n; i++){
		    sumB[index]+=B[i];
		}
		Arrays.sort(sumB);
		int cnt = 0;
		for(int i = 0; i < sumA.length; i++){
		    cnt += upperBound(sumA[i], T, sumB) -lowerBound(sumA[i], T, sumB);
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}