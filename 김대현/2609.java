import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Scanner;


public class 2609 {	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Main m = new Main();
		
		System.out.println(m.gcd(a,b));
		System.out.println(m.lcm(a, b));
		
		
	}
	
	public int gcd(int a, int b) {
		if(b == 0) 
			return a;
		else
			return gcd(b, a%b);
			
	}
	
	public int lcm(int a, int b) {
		return (a*b)/gcd(a, b);
	}
}
	
	
	



