import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		char[][] arr = new char[5][15];

		int max = 0;

		for ( int i = 0 ; i < 5 ; i++ ) {
			String str = sc.nextLine();
			if ( str.length() > max )
				max = str.length();
			for ( int j = 0 ; j < str.length() ; j++ )
				arr[i][j] = str.charAt(j);
		}
		
		for ( int i = 0 ; i < 15 ; i++ ) 
			for ( int j = 0 ; j < 5 ; j++ ) {
				if ( arr[j][i] == '\0' ) 
					continue;
				System.out.print(arr[j][i]);
				}
		sc.close();
	}
}