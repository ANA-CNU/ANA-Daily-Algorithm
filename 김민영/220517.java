import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		int[] num=new int[input.length()];
		for(int i=0;i<input.length();i++) {
			num[i]=input.charAt(i)-'0';
		}
		for(int i=0;i<num.length;i++) {
			int changed=0;
			for(int j=0;j<num.length-i-1;j++) {
				if(num[j]<num[j+1]) {
					int tmp=num[j];
					num[j]=num[j+1];
					num[j+1]=tmp;
					changed=1;
				}
			}
			if(changed==0) break;
		}
		for(int i=0;i<input.length();i++) {
			System.out.print(num[i]);
		}

	}

}
