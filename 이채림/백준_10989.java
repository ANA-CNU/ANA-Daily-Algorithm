import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class 백준_10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[] array = new int[10001]; // index => 해당숫자, 값  => 숫자의 갯수
		Arrays.fill(array, 0); // 배열 0으로 채우기
		
		for (int i = 0; i < N; i++) {
			array[Integer.parseInt(br.readLine())] += 1;
		}

		for(int i = 0; i < 10001; i++) {
			for(int j = 0; j < array[i]; j++) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
