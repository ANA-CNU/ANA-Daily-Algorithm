import java.io.*;
import java.util.*;

public class J7578 {
	static int N;
	static int arr[] = new int[500000];
	static long ans = 0;

	static int[] devide(int l, int r) {
		if (l == r) {
			int temp[] = new int[1];
			temp[0] = arr[l];
			return temp;
		}

		int mid = (l + r) / 2;
		int left[] = devide(l, mid);
		int right[] = devide(mid + 1, r);

		int lsize = mid - l + 1;
		int rsize = r - mid;
		int size = r - l + 1;
		int lndex = 0, rndex = 0;

		int temp[] = new int[size];

		for (int i = 0; i < size; i++) {
			if (rndex < rsize && (lndex == lsize || right[rndex] < left[lndex])) {
				ans += (lsize - lndex);
				temp[i] = right[rndex++];
			} else {
				temp[i] = left[lndex++];
			}
		}

		return temp;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> indexing = new HashMap<Integer, Integer>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			indexing.put(n, i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			arr[i] = indexing.get(n);
		}

		devide(0, N - 1);

		System.out.println(ans);
	}
	
}
