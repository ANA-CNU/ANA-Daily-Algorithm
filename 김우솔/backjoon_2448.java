package done;

import java.io.*;

public class backjoon_2448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        char[][] arr = new char[a][a * 2];
        makestar(a, arr);
        deleterecursive(0, a * 2,0, a, arr);

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a * 2; j++) {
                bw.write(arr[i][j]);
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();

    }

    static void makestar(int a, char[][] arr) {
        for (int i = 0, j = a - 1; i < a; j--, i++) {
            for (int k = a; k >= 0; k--) {
                arr[i][k] = ' ';
            }
            for (int k = 0; k < i * 2 + 1; k++) {
                arr[i][k + j] = '*';
            }
            for (int k = a + i; k < a * 2; k++) {
                arr[i][k] = ' ';
            }
        }
    }
    static void deleterecursive(int xleft, int xright, int yup, int ydown, char[][] arr) {
        if (ydown - yup <= 3) {
            arr[(yup + ydown) / 2][(xleft + xright)/2 - 1] = ' ';
            return;
        }

        int ymid = (yup + ydown) / 2;
        int xmid = (xleft + xright) / 2;
        int xmidleft = (xleft + xmid) / 2;
        int xmidright = (xmid + xright) / 2;

        for (int i = ymid, k = 0; i < ydown; k++, i++) {
            for (int j = k; j < xmidright - xmidleft - k - 1; j++) {
                arr[i][xmidleft + j] = ' ';
            }
        }

        deleterecursive(xmidleft, xmidright, yup, ymid, arr);
        deleterecursive(xleft, xmid, ymid, ydown, arr);
        deleterecursive(xmid, xright, ymid, ydown, arr);
    }
}
