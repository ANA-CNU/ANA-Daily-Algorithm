import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class 10818 {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int max = -1000001;
		int min = 1000001;
		
		for(int i = 0; st.hasMoreTokens(); i++) {
			int val = Integer.parseInt(st.nextToken());
			if(max < val)
				max = val;
			if(min > val)
				min = val;
		}
		
		System.out.println(min + " " + max);
		
		
		}
	}
	



