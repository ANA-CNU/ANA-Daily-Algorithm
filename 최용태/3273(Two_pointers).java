import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		String anum=br.readLine();
		StringTokenizer an=new StringTokenizer(anum," ");
		int total = Integer.parseInt(br.readLine());
		int count=0;
		int[] a=new int[N];
		
		for(int i=0;i<N;++i)
			a[i]=Integer.parseInt(an.nextToken());
		
		Arrays.sort(a);
		
		for(int start=0;start<N-1;++start) {
			for(int end=start+1;end<N;++end) {
				int cmp=a[start]+a[end];
				if(cmp<total)
					continue;
				else {
					if(cmp==total)
						count++;
					break;
				}
			}
		}

		bw.write(count+"");
		bw.flush();
		
	}
}