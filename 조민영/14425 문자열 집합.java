import java.io.*;
import java.util.*;

public class Main {
	public static String[] words;
	public static int n;
	public static boolean check ( String str ) {
		for ( int i = 0 ; i < n ; i++ ) {
			if ( words[i].equals(str) )
				return true;
		}
		return false;
	}
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		words = new String[n];
		int cnt = 0;

		for ( int i = 0 ; i < n ; i++ ) 
			words[i] = br.readLine();

		for ( int i = 0 ; i < m ; i++ ) {
			String str = br.readLine();
			if ( check(str) )
				cnt++;
		}

		System.out.print(cnt);
    }
}