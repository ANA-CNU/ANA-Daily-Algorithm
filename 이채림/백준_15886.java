import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 백준_15886 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String map = br.readLine();
		
		int cnt = 0;

		for(int i = 0; i < map.length()-1; i++) {
			if(map.charAt(i) == 'E' && map.charAt(i+1) == 'W') {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
