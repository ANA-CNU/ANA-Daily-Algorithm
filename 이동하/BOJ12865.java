import java.util.*;
import java.io.*;

public class BOJ12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int things = Integer.parseInt(st.nextToken());
        int[] weights = new int[Integer.parseInt(st.nextToken())+1];
        for (int i = 1; i < weights.length; i++) {
            weights[i] = -1;
        }
        for (int i = 0; i < things; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            for (int j = weights.length - W - 1; j >= 0 ; j--) {
                if (weights[j] != -1) {
                    weights[j+W] = Math.max(weights[j] + value, weights[j+W]);

                }
            }
        }
        Arrays.sort(weights);
        System.out.println(weights[weights.length-1]);
    }
}
