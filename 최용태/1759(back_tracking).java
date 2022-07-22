import java.io.*;
import java.util.*;

public class Main {
	static int m = 0;
	static int[] selected;
	static boolean[] visited;
	static int[] charArr;
	static char[] A_arr={'a','e','i','o','u'};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void search(int n) throws IOException {
		if (n > m) {
			int count1=0;
			int count2=0;
			
			for(int i=1;i<=m;i++) {
				switch(selected[i]) {
					case 'a' :
					case 'e' :
					case 'i' :
					case 'o' :
					case 'u' :
						count1++;
						break;
					default :
						count2++;
				}
			}
			if(count1<1 || count2 <2) {
				return;
			}
			
			for (int i = 1; i <= m; i++)
				bw.write((char)selected[i]);
			bw.write("\n");
				
		}else {
			for(int i=0;i<charArr.length;i++) {
				if(selected[n-1]<=charArr[i] && !visited[i]) {
					visited[i]=true;
					selected[n]=charArr[i];
					search(n+1);
					visited[i]=false;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {

		StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
		String str=br.readLine();
		
		m=Integer.parseInt(ss.nextToken());
		
		charArr = new int[Integer.parseInt(ss.nextToken())];
		int x=1;
		
		charArr[0]=str.charAt(0);
		for(int i=2;i<str.length();i=i+2) {
			charArr[x++]=str.charAt(i);
		}

		selected=new int[m+1];
		visited=new boolean[charArr.length];
		Arrays.sort(charArr);
		search(1);
		bw.flush();
	}
}