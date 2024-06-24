package done;

import java.io.*;
import java.util.*;

public class backjoon_1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] arr = new int[N][2]; //0 번째 1 값
        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i + 1;
        }

        List<Integer> list = new LinkedList<>();
        list.add(arr[arr.length - 1][1]);
        for (int i = N - 2; i >= 0; i--) {
            list.add(arr[i][0], arr[i][1]);
        }

        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i) + " ");
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }
}

