import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void arrPrint(boolean r,int[] a,int frontSpace,int rearSpace) throws IOException {
		bw.write("[");
		if(r) {
			for(int i=a.length-1-rearSpace;i>=frontSpace;i--) {
				bw.write(a[i]+"");
				if(i!=frontSpace)
					bw.write(",");
			}
		}else {
			for(int i=frontSpace;i<=a.length-1-rearSpace;i++) {
				bw.write(a[i]+"");
				if(i!=a.length-1-rearSpace)
					bw.write(",");
			}
		}
		bw.write("]\n");
	}
	
	public static void TestCase() throws IOException {
		int frontSpace = 0;
		int rearSpace = 0;
		boolean r = false;
		String cmd = br.readLine();
		int size = Integer.parseInt(br.readLine());
		int[] a = new int[size];
		StringTokenizer arrSource = new StringTokenizer(br.readLine(), "[],");

		for (int i = 0; i < size; i++) {
			a[i] = Integer.parseInt(arrSource.nextToken());
		}

		for (int i = 0; i < cmd.length(); i++) {
			switch (cmd.charAt(i)) {
			case 'R':
				r = !r;
				break;
			case 'D':
				if (size == 0) {
					bw.write("error\n");
					return;
				} else {
					if (r)
						rearSpace++;
					else
						frontSpace++;
					
					size--;
				}
			}
		}
		
		arrPrint(r,a,frontSpace,rearSpace);
	}

	public static void run() throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			TestCase();
		}
		bw.flush();
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
