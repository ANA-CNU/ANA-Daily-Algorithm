import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		boolean[] prime = new boolean[N+1];
		Arrays.fill(prime, true);
		int cnt = 0;
		for(int i = 2; i <= N; i++){
		    if(!prime[i]) continue;
		    for(int j = i *2; j <=N; j += i){
		        prime[j] = false;   
		    }
		 }	
		 for(int i = 2; i <= N; i++){
		     if(prime[i])cnt++;
		 }
		 
		int[] sum = new int[cnt+1];
		cnt = 0;
		int index = 1;
		for(int i = 2; i <= N; i++){
		    if(prime[i]){
		        sum[index] = i + sum[index-1];
		        index++;
		    }
		}
		int left = 0;
		int right =1;
		while(left <= right && right < sum.length){
		     int now = sum[right] -sum[left];
		      if(N == now) {
		          left++;
		          right++;
		          cnt++;
		      }else if(N > now){
		          right++;
		      }else{
		          left++;
		      }
		}
		bw.write(Integer.toString(cnt));
		bw.flush();
		bw.close();
		br.close();
	}
}