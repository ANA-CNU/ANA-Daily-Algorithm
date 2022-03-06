import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 백준_3230 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> players = new LinkedList<>();
		LinkedList<Integer> two = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			players.add(Integer.parseInt(st.nextToken())-1,i+1);			
		}	
		
		int removeSize = players.size() - M;
		
		for(int i = 0; i < removeSize; i++) {
			players.removeLast();
		}
				
		Collections.reverse(players);
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			two.add(Integer.parseInt(st.nextToken())-1, players.get(i));
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println(two.get(i));
		}
	}
}
