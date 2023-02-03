import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int[] C = new int[10001];

        while (count > 0) {
            C[Integer.parseInt(br.readLine())]++;
            count--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < C.length; i++) {
            while (C[i] > 0) {
                sb.append(i).append("\n");
                C[i]--;
            }
        }

        System.out.println(sb);
    }
}
