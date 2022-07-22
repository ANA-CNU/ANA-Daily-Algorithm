import java.io.*;

public class subMain {

	static int count = 0;
	static int MAX_n = 0;
	static int Visited[];
	public static boolean visiting(int n) {
		for(int i=0;i<n;i++) {
			if(Visited[n]==Visited[i] || n-i==Math.abs(Visited[i]-Visited[n])) {
				return false;
			}
		}
		return true;
	}

	public static void search(int n) {
		if (n == MAX_n) {
			count++;
			return;
		} else {
			for (int i = 0; i < MAX_n; i++) {
				Visited[n]=i;
				if(visiting(n)) {
					search(n+1);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		MAX_n = N;
		Visited = new int[MAX_n];
		for(int i=0;i<N;i++)
			Visited[i]=-1;
		search(0);
		System.out.println(count);
	}
}
