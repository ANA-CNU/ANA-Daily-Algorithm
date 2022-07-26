import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		
		int n=Integer.parseInt(s.nextToken());
		int N=Integer.parseInt(s.nextToken());
		int count=1;
		while(N!=n) {
			if(N%10==1 && N!=1) {
				N/=10;
			}
			else if(N%2==0) {
				N/=2;
			}
			else {
				count=-1;
				break;
			}
			count++;
		}
		
		System.out.println(count);
	}
}