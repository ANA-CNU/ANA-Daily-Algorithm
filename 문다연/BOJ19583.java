package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import annotation.*;
@BOJ(   number = 19583,
        tier = BaekjoonTier.SILVER_II,
        solveDate = @SolveDate(year = 2022, month = 3 ,day = 31))
public class BOJ19583 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int [][] time = new int[3][];
        for (int i = 0; i < 3; i++) {
            time[i] = new int[2];
            String [] token = st.nextToken().split(":");
            time[i][0] = Integer.parseInt(token[0]);
            time[i][1] = Integer.parseInt(token[1]);
        }

        int count = 0;
        String chatting = null;
        HashMap <String, Integer> map = new HashMap<>();
        int status = -1; // -1: 개강 총회 시작 전, 0: 개강총회 중, 1: 개강총회 끝, 2: 개강총회 스트리밍 끝
        while ((chatting = br.readLine()) != null) {
            if (chatting.equals("")) break;
            st = new StringTokenizer(chatting);
            String [] log = st.nextToken().split(":");
            int hour = Integer.parseInt(log[0]);
            int min = Integer.parseInt(log[1]);
            if (hour > time[2][0] || (hour == time[2][0] && min > time[2][1])) status = 2;
            else if (hour > time[1][0] || (hour == time[1][0] && min >= time[1][1])) status = 1;
            else if (hour > time[0][0] || (hour == time[0][0] && min > time[0][1])) status = 0;
            else status = -1;

            String name = st.nextToken();

            switch (status) {
                case -1:
                    if (!map.containsKey(name)) map.put(name, 0);
                    break;
                case 1:
                    if (map.containsKey(name)) {
                        if (map.get(name) == 0) {
                            count++;
                            map.replace(name, 1);
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(count);
    }
}
