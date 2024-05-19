import java.io.*;
import java.util.*;

public class Main {
	public static char[] row = {'A','B','C','D','E','F','G','H'};
	public static int[] king, rock;

	public static boolean check ( int[] arr ) {
		if ( arr[0] < 0 || arr[0] > 7 || arr[1] < 0 || arr[1] > 7 )
			return true;
		return false;
	}
	public static void move(String com, int[] arr) {
		for ( int i = 0 ; i < com.length() ; i++ ) {
			char c = com.charAt(i);

			switch (c) {
				case 'R':
					arr[0]++;
					break;
				case 'L':
					arr[0]--;
					break;
				case 'B':
					arr[1]--;
					break;
				case 'T':
					arr[1]++;
					break;
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer str = new StringTokenizer(br.readLine());
		String kingPos = str.nextToken();
		String rockPos = str.nextToken();
		int n = Integer.parseInt(str.nextToken());

		king = new int[]{kingPos.charAt(0)-'A',kingPos.charAt(1)-'1'};
		rock = new int[]{rockPos.charAt(0)-'A',rockPos.charAt(1)-'1'};

		while ( n-- > 0 ) {
			String com = br.readLine();
			int[] newKing = {king[0], king[1]};
			move(com,newKing);

			if ( check(newKing) )
				continue;

			if ( newKing[0] == rock[0] && newKing[1] == rock[1] ) {
				int[] newRock = {rock[0], rock[1]};
				move(com, newRock);

				if ( check(newRock) )
					continue;

				rock = newRock;
			}

			king = newKing;
		}

		System.out.println("" + row[king[0]] + (king[1]+1));
		System.out.println("" + row[rock[0]] + (rock[1]+1));
    }
}