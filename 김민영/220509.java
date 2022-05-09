import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException; 
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String one=br.readLine();
		int n=Integer.parseInt(one);
		String[] bzip=new String[n];
		String[] zip=new String[n];
		
		for(int i=0;i<n;i++) {
			String tmp=br.readLine();
			String[] ttmp=tmp.split(" ");
			bzip[i]=ttmp[0];
			zip[i]=ttmp[1];
		}
		
		String input=br.readLine();
		String num=br.readLine();
		String[] nnum=num.split(" ");
		
		int a=Integer.parseInt(nnum[0]);
		int b=Integer.parseInt(nnum[1]);
		
		StringBuilder sb=new StringBuilder();
		
		for(int i=0;i<input.length();i++) {
			for(int j=0;j<n;j++) {
				if(input.substring(i,i+1).equals(zip[j])) {
					sb.append(bzip[j]);
				}
			}
		}
		
		System.out.println(sb.substring(a-1,b));
	}

}
