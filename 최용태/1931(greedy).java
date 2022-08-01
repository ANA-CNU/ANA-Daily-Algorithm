import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static ArrayList<TimeTable> T;

	public static class TimeTableCompartor implements Comparator<TimeTable> {
		@Override
		public int compare(TimeTable a, TimeTable b) {
			if (a.start > b.start)
				return 1;
			else if (a.start < b.start)
				return -1;
			else {
				if (a.end > b.end)
					return 1;
				else if ((a.end < b.end))
					return -1;
			}
			return 0;
		}

	}

	public static class TimeTable {
		int start;
		int end;
		int counted = 0;

		TimeTable(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void inputData(int size) throws IOException {
		T = new ArrayList<TimeTable>(size);

		for (int i = 0; i < size; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine(), " ");
			int ss = Integer.parseInt(s.nextToken());
			int e = Integer.parseInt(s.nextToken());
			T.add(new TimeTable(ss, e));
		}
	}

	public static void run() throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		inputData(N);
		sorting();

		int ans = search();
		//for (int i = 0; i < N; i++) System.out.println(i + ": " + T.get(i).start + " " + T.get(i).end + ", 카운트 : " + T.get(i).counted);
		System.out.println(ans);
	}

	public static int search() {
		int result = 0;
		int resultIdx = 0;
		int size = T.size();

		for (int current = size - 1; current >= 0; current--) {
			int value = 0;

			if (T.get(resultIdx).start >= T.get(current).end)
				value = T.get(resultIdx).counted;

			T.get(current).counted += value + 1;

			if (result < T.get(current).counted) {
				resultIdx = current;
				result = T.get(current).counted;
			}
		}

		return result;
	}

	public static void sorting() {
		Collections.sort(T, new TimeTableCompartor());
	}

	public static void main(String[] args) throws Exception {
		run();
	}
}
