import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		int[] zero=new int[41];
		int[] one=new int[41];
		zero[0]=1;
		one[1]=1;
		for(int i=2;i<41;i++) {
			zero[i]+=zero[i-2]+zero[i-1];
			one[i]+=one[i-2]+one[i-1];
		}
		
		for(int i=0;i<N;i++) {
			int n=Integer.parseInt(br.readLine());
				bw.write(zero[n]+" "+one[n]+"\n");
		}
		bw.flush();
	}
}

