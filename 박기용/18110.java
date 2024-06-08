import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int[] comments = new int[count];

        for (int i = 0; i < count; i++) {
            comments[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(comments);

        double extreme = (double) count * 3 / 20 + 0.5;
        int ex = (int) extreme;

        for (int i = 0; i < ex; i++) {
            comments[i] = 0;
        }

        for (int i = count - ex; i < count; i++) {
            comments[i] = 0;
        }

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += comments[i];
        }

        double average = (double) sum / (count - ex * 2) + 0.5;
        int ave = (int) average;

        bw.write(ave + "");
        bw.close();
    }
}
