import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static int Search(int[] a, int left, int right, int key) {
		int mid = (left + right) / 2;
		while (mid > left) {
			if (a[mid] < key)
				left = mid + 1;
			else if (a[mid] > key)
				right = mid - 1;
			else
				break;
			mid = (left + right) / 2;
		}

		if (a[mid] < key && mid + 1 < a.length)
			return mid + 1;
		else
			return mid;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] answer = new int[2];
		int least = 2000000001;
		String num = br.readLine();
		StringTokenizer anum = new StringTokenizer(num, " ");

		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(anum.nextToken());
		}
		Arrays.sort(a);
		int start = 0;
		int end = a.length - 1;

		while (start < end) {
			int cmpIndex = Search(a, start + 1, end, Math.abs(a[start])); // 가장 비슷한 값 찾기
			int cmpValue = 0;
			
			if (Math.abs(a[start] + a[cmpIndex]) < Math.abs(a[start] + a[cmpIndex - 1]) || cmpIndex - 1 == start) {
				end = cmpIndex;
				cmpValue = Math.abs(a[start] + a[cmpIndex]); // 앞과 뒤 중 더 비슷한 값 찾기
			} else {
				end = cmpIndex - 1;
				cmpValue = Math.abs(a[start] + a[cmpIndex - 1]);
			}

			if (cmpValue < least) {
				least = cmpValue;
				answer[0] = a[start];
				answer[1] = a[end];
			}
			start++;
		}
		System.out.println(answer[0] + " " + answer[1]);
	}
}