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

		String s = br.readLine();
		char odd ='!';
		boolean sorry = false;
		int[] r = new int[91];

		for (int i = 0; i < s.length(); i++)
			r[s.charAt(i)]++;
		for (int i = 'A'; i <= 'Z'; i++) {
			if (r[i] % 2 != 0) {
				if (odd!='!') {
					sorry = true;
					break;
				}
				odd = (char)i;
			}
		}

		if (sorry) {
			System.out.println("I'm Sorry Hansoo");
		} else {
			for (int i = 'A'; i <= 'Z'; i++) {
				char current = (char)i;
				int half = r[current] / 2;
				int count=0;
				while (count != half) {
					bw.write(current + "");
					r[current]--;
					count++;
				}
			}
			if(odd!='!') {
				bw.write(odd+"");
				r[odd]--;
			}
			for (int i = 'Z'; i >= 'A'; i--) {
				char current = (char)i;
				while (r[current] != 0) {
					bw.write(current + "");
					r[current]--;
					if(r[current]==0)
						break;
				}
			}
		}
		
		bw.flush();

	}
}