

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        int len = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[len];
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < len; i++) {
            int cnt =0;
            for (int j = 0; j < len; j++) {
                cnt+= Math.abs(arr[i] - arr[j]);
            }
            ret[i] = cnt;
        }

        int minValue = arr[0];
        int minIndex = 0;
        for (int i = 0; i < len; i++) {
            if(ret[minIndex] == ret[i]) {
                minValue = Math.min(minValue, arr[i]);
            }
            if(ret[minIndex] > ret[i]) {
                minValue = arr[i];
                minIndex = i;
            }
        }

        System.out.println(minValue);
    }
}