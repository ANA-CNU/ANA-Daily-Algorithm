import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int[] arr = new int[input];

        for (int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        int output = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < output; i++) {
            boolean a = false;
            int b = Integer.parseInt(st2.nextToken());
            for (int j = 0; j < input; j++) {
                if (b == arr[j]) {
                    bw.write("1");
                    a = true;
                    break;
                }
            }
            if (!a)
                bw.write("0");
            bw.newLine();
        }
        bw.close();
    }
}
