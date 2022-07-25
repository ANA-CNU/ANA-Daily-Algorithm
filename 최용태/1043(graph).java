import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void searchBlock(boolean[] partyBlocked,boolean[] TRUE,int[][] party,int M) {
		for (int z =M-1; z > -1; z--) {
			for (int x = 0; x < party[z].length; x++) {
				if (TRUE[party[z][x]]) {
					partyBlocked[z] = true;
					break;
				}
			}
		}
	}
	public static void searchTRUE(boolean[] TRUE,boolean[][] peopleNode,int N) {
		for (int j = 1; j < N + 1; j++) {
			if (TRUE[j]) { // TRUE인 사람과 연결된 모든 사람들도 TRUE
				for (int x = 1; x < N + 1; x++) {
					if (peopleNode[j][x]) {
						TRUE[x] = true; // 연결된 사람과 연결된 사람들도 TRUE
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer s = new StringTokenizer(br.readLine(), " ");
		StringTokenizer ts = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(s.nextToken());
		int M = Integer.parseInt(s.nextToken());
		int T = Integer.parseInt(ts.nextToken());

		int[][] party = new int[M][];
		boolean[] TRUE = new boolean[N + 1];
		boolean[][] peopleNode = new boolean[N + 1][N + 1];
		boolean[] partyBlocked = new boolean[M];
		int count = 0;

		for (int i = 0; i < T; i++) {
			int current = Integer.parseInt(ts.nextToken());
			TRUE[current] = true;
			peopleNode[current][current]=true;
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer snum = new StringTokenizer(br.readLine(), " ");
			int size = Integer.parseInt(snum.nextToken());

			party[i] = new int[size]; // 파티만큼 사람이 존재

			for (int j = 0; j < size; j++) { // 파티 정보 채워넣기
				int cmp = Integer.parseInt(snum.nextToken());
				party[i][j] = cmp;
				if(TRUE[cmp])
					partyBlocked[i]=true;
			}

			for (int j = 0; j < size; j++) { // 연결 정보 채워넣기
				int start = party[i][j];
				for (int k = 0; k < size; k++) {
					int end = party[i][k];
					peopleNode[start][end] = true;
					peopleNode[end][start] = true;
				}
			}

			if (partyBlocked[i]) {
				for (int j = 0; j < size; j++) {
					TRUE[party[i][j]] = true; // 현재 파티에 참여한 모든 사람들 TRUE
				}
			}
			
			for(int d=1;d<N+1;d++) {
				searchTRUE(TRUE, peopleNode, N);
			}
		}
		
		searchTRUE(TRUE, peopleNode, N);
		searchBlock(partyBlocked, TRUE, party, M);

		for(int i=1;i<N+1;i++) {
			if(TRUE[i])
			System.out.println("TRUE: "+i);
		}
		for (int i = 0; i < M; i++) {
			if (!partyBlocked[i]) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}