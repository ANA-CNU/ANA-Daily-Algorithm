// 일반화는 나중에

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = sc.nextInt();
        String[][] arr = new String[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                arr[i][j] = "*";
            }
        }

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= num; j++) {
                switch (num) {
                    case 2187:
                    if (i % 2187 > 1*729 && i % 2187 <= 2*729 && j % 2187 > 1*729 && j % 2187 <= 2*729) {
                        arr[i - 1][j - 1] = " ";
                    } case 729: if (i % 729 > 1*243 && i % 729 <= 2*243 && j % 729 > 1*243 && j % 729 <= 2*243) {
                        arr[i - 1][j - 1] = " ";
                    } case 243: if (i % 243 > 1*81 && i % 243 <= 2*81 && j % 243 > 1*81 && j % 243 <= 2*81) {
                        arr[i - 1][j - 1] = " ";
                    } case 81: if (i % 81 > 1*27 && i % 81 <= 2*27 && j % 81 > 1*27 && j % 81 <= 2*27) {
                        arr[i - 1][j - 1] = " ";
                    } case 27: if (i % 27 > 1*9 && i % 27 <= 2*9 && j % 27 > 1*9 && j % 27 <= 2*9) {
                        arr[i - 1][j - 1] = " ";
                    } case 9: if (i % 9 > 1*3 && i % 9 <= 2*3 && j % 9 > 1*3 && j % 9 <= 2*3) {
                        arr[i - 1][j - 1] = " ";
                    } case 3: if (i % 3 > 1 && i % 3 <= 2 && j % 3 > 1 && j % 3 <= 2) {
                        arr[i - 1][j - 1] = " ";
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }
        bw.close();
    }
}
