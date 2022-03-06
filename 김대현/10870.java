import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class 10870 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a = Integer.parseInt(br.readLine());
		
		Main m = new Main();
		
		System.out.println(m.Fibonacci(a));
		}
	
	public int Fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1) return 1;
		return Fibonacci(n-1) + Fibonacci(n-2);
	}
	}
	
	



