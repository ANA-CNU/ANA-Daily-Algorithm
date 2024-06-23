package done;

import java.io.*;
import java.util.*;

public class backjoon_30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] check = new int[2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        check[0] = arr[0];
        int start = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((check[0] != arr[i]) && (check[1] == 0)) check[1] = arr[i];//2가 없으면 넣어주기
            if ((check[0] == arr[i]) || (check[1] == arr[i])) { //같다면
                if (max < i - start+ 1) max = i - start + 1;
            } else {//아니라면
                check[0] = arr[i];
                check[1] = 0;
                for (int j = i; j >= start; j--) {
                    if ((check[0] != arr[j]) && (check[1] == 0)) check[1] = arr[j];
                    if ((check[0] != arr[j]) && (check[1] != arr[j])) {
                        start = j + 1;
                        break;
                    }
                }
            }
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }
}
