import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		StringBuilder sb=new StringBuilder();
		int k=1;
		for(int i=0;i<input.length();i+=k) {
			char tmp=input.charAt(i);
			if(i<input.length()-2&&tmp!=input.charAt(i+1)&&tmp!=input.charAt(i+2)&&input.charAt(i+1)!=input.charAt(i+2)) {
				sb.append("C");
				k=3;
			}
			else if(tmp=='R') {
				sb.append("S");
				k=1;
			}
			else if(tmp=='B') {
				sb.append("K");
				k=1;
			}
			else if(tmp=='L') {
				sb.append("H");
				k=1;
			}
		}
		System.out.println(sb);

	}

}
