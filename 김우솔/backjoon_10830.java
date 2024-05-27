package havetostudy;

import java.io.*;
import java.util.*;

public class backjoon_10830 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int len = Integer.parseInt(st.nextToken());
        long pow = Long.parseLong(st.nextToken());
        int[][] arr = new int[len][len];
        int[][] remainmat = new int[len][len];

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            remainmat[i][i] = 1;
        }

        while (true) {
            if (pow <= 1) break;
            if (pow % 2 == 0) { //짝수인경우
                arr = Matrixmulty(arr, arr);
                pow /= 2;
            }else {
                remainmat = Matrixmulty(arr, remainmat);
                arr = Matrixmulty(arr, arr);
                pow /= 2;
            }
        }
        arr = Matrixmulty(arr, remainmat);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                bw.write(arr[i][j] % 1000 + " ");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }
    static int[][] Matrixmulty(int[][] arr, int[][] brr) {
        int[][] ans = new int[arr.length][arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = 0; k < arr.length; k++) {
                    ans[i][j] += arr[i][k] * brr[k][j];
                    ans[i][j] %= 1000;
                }
            }
        }

        return ans;
    }
}
