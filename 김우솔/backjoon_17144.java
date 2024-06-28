package done;

import java.io.*;
import java.util.*;

public class backjoon_17144 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        int[] airclean = new int[2];

        for (int i = 0; i < row; i++) { //좌표값
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < row; i++) { //공청기 위치
            if (arr[i][0] == -1) {
                airclean[0] = i;
                airclean[1] = i + 1;
                break;
            }
        }

        ArrayList<int[]> al = new ArrayList<>();
        int[][] temparr;
        while (T != 0) {//t시간마다 변화
            //미세먼지 확산
            al.clear(); // 좌표 체크
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (arr[i][j] > 0) {
                        al.add(new int[]{i, j, arr[i][j]});
                    }
                }
            }
            //확산 시작
            int count;
            temparr = new int[row][col];
            for (int i = 0; i < al.size(); i++) {
                count = 0;
                int y = al.get(i)[0];//i, j, value
                int x = al.get(i)[1];
                int val = al.get(i)[2];
                if (y + 1 < row && !(x == 0 && y + 1 == airclean[0])) {//위
                    count++;
                    temparr[y + 1][x] += val / 5;
                }
                if (y - 1 >= 0 && !(x == 0 && y - 1 == airclean[1])) { //아래
                    count++;
                    temparr[y - 1][x] += val / 5;
                }
                if (x + 1 < col) {//오른쪽
                    count++;
                    temparr[y][x + 1] += val / 5;
                }
                if (x - 1 >= 0 && !((airclean[0] == y || airclean[1] == y) && x - 1 == 0)) {//왼쪽
                    count++;
                    temparr[y][x - 1] += val / 5;
                }
                temparr[y][x] += val - (val / 5 * count);
            }
            arr = temparr.clone();
            //공청기 작동 // 위에 작동
            for (int i = airclean[0] - 1; i >= 0; i--) {
                arr[i + 1][0] = arr[i][0];
            }
            for (int i = 0; i < col - 1; i++) {
                arr[0][i] = arr[0][i + 1];
            }
            for (int i = 0; i < airclean[0]; i++) {
                arr[i][col - 1] = arr[i + 1][col - 1];
            }
            for (int i = col - 1; i > 0; i--) {
                arr[airclean[0]][i] = arr[airclean[0]][i - 1];
            }
            //아래 작동
            for (int i = airclean[1]; i < row - 1; i++) {
                arr[i][0] = arr[i + 1][0];
            }
            for (int i = 0; i < col - 1; i++) {
                arr[row - 1][i] = arr[row - 1][i + 1];
            }
            for (int i = row - 1; i > airclean[1]; i--) {
                arr[i][col - 1] = arr[i - 1][col - 1];
            }
            for (int i = col - 1; i > 0; i--) {
                arr[airclean[1]][i] = arr[airclean[1]][i - 1];
            }
            arr[airclean[1]][1] = arr[airclean[0]][1] = 0;
            arr[airclean[1]][0] = arr[airclean[0]][0] = -1;
            T--;
        }

        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                count += arr[i][j];
            }
        }
        bw.write(count + 2 + "\n");
        bw.flush();
        bw.close();
    }
}
