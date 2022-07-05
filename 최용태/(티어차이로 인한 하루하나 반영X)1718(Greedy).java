import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String ss=br.readLine();
		String bb=br.readLine();
		char[] str=ss.toCharArray();
		char[] b=new char[str.length];
		int current=0;
		
		for(int i=0;i<b.length;i++)
			b[i]=bb.charAt(((current++)%bb.length()));
		
		current=0;
		
		for(int i=0;i<str.length;i++) {
			if(str[i]==' ')
				bw.write(" ");
			else {
				int order=b[i]-'a'+1; // 이만큼 뒤로 가야한다.
				char result=(char)((str[i]-'a'+(26-order))%26+'a');
				bw.write(result+"");
			}
		}
		bw.flush();
	}
}