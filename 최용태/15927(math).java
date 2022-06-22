import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		int size = str.length();
		boolean arr[] = new boolean[100];
		if (size == 1)
			System.out.println(-1);
		else {
			for (int i = 0; i < size / 2; i++) {
				if (str.charAt(i) != str.charAt(size - 1 - i)) {
					System.out.println(size);
					return;
				} else
					arr[str.charAt(i)] = true;
			}
			boolean twotrue = false;
			boolean ttwotrue = false;
			for (int i = 30; i < 100; i++) {
				if (arr[i] == true) {
					if (!twotrue)
						twotrue = true;
					else {
						ttwotrue=true;
						break;
					}
				}
			}

			if ((str.charAt(size / 2) != str.charAt(0)) && size % 2 != 0 || ttwotrue) {
				System.out.println(size - 1);
			} else
				System.out.println(-1);
		}
	}
}