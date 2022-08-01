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
		String str=br.readLine();
		int count=0;
		boolean[] s=new boolean[str.length()+1];
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='Y')
				s[i+1]=true;
		}
		
		for(int i=1;i<s.length;i++) {
			if(s[i]) {
				for(int j=i;j<s.length;j=j+i) {
					s[j]=!s[j];
				}
				count++;
			}
		}
		System.out.println(count);
	}
}