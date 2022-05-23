

import java.io.*;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i+1; j++) {
                sum+= arr.get(j);
            }
        }

        System.out.println(sum);
    }
}