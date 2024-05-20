package done;

import java.io.*;
import java.util.*;

public class backjoon_1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int partynum = Integer.parseInt(st.nextToken());
        int[][] arr = new int[partynum][]; //파티의 정보를 담고있음
        boolean[] lie = new boolean[people + 1]; //진실이면 true
        boolean[] party = new boolean[partynum]; //진실인 파티를 더 방문하는지 안하는지

        st = new StringTokenizer(br.readLine());
        int truenum = Integer.parseInt(st.nextToken());
        for (int i = 0; i < truenum; i++) {
            lie[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[Integer.parseInt(st.nextToken())];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /**
         * 이제 반복문을 돌면서 배열이 바뀌는지 확인
         */
        while (true) {
            boolean[] comp = party.clone();

            for (int i = 0; i < arr.length; i++) {
                if (party[i]) continue; //진실인 사람이 있으면 안감
                boolean flag = false; //진실을 아는 사람이 있는지 검사
                for (int j = 0; j < arr[i].length; j++) {
                    if (lie[arr[i][j]]) {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    for (int j = 0; j < arr[i].length; j++) {
                        lie[arr[i][j]] = true;
                    }
                    party[i] = true;
                }
            }

            if (Arrays.equals(party, comp)) break;
        }

        int count = 0;
        for (int i = 0; i < party.length; i++) {
            if (!party[i]) count++;
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}

