import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1181 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		ArrayList<String> arr = new ArrayList<String>(set);
		
		Collections.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}

			}
		});
		
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}


	}
}
