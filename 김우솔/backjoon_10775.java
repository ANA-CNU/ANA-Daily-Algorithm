package Greedy;

import java.io.*;

public class backjoon_10775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /**
         * 이 문제는 그리디 or union find문제이다
         * 해당 비행기위 마지막 위치를 저장하고 다음에 찾을 때에는 그 마지막 위치부터
         * 찾는 그리디 알고리즘을 사용했다
         */

        int n = Integer.parseInt(br.readLine());
        int plain = Integer.parseInt(br.readLine());
        int[] lastcheck = new int[n + 1];
        int[] arr = new int[plain];
        boolean[] vis = new boolean[n + 1];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());;
        }

        for (int i = 0; i < lastcheck.length; i++) {
            lastcheck[i] = i;
        }

        for (int i = 0; i < plain; i++, count++) {
            int temp = arr[i];

            if (vis[temp]) { //방문 했으면
                boolean flag = false;
                for (int j = lastcheck[temp]; j > 0; j--) {
                    if (!vis[j]) {//처음보는곳이면
                        lastcheck[temp] = j;//위치 저장하고
                        vis[j] = true;//방문표시
                        flag = true;//방문했다는 표시
                        break;
                    }
                }
                if (!flag) break;
            }else {//안했으면
                vis[temp] = true;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}