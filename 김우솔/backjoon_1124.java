package Mathematics;

import java.io.*;
import java.util.*;

public class backjoon_1124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[100001];
        List<Integer> list = new ArrayList<>();
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                list.add(i);
                for (int j = i * 2; j < prime.length; j += i) {
                    prime[j] = false;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int count = 0;//언더프라임 개수

        for (int i = a; i <= b; i++) {
            int temp = 0; // 소수 개수
            int save = i; //값을 저장하는 임시 값
            boolean flag = false;
            while (true) {
                for (int j = 0; j < list.size(); j++) {
                    if (save < list.get(j)) {
                        flag = true;
                        break;
                    }
                    if (save % list.get(j) == 0) {
                        temp++;
                        save /= list.get(j);
                        break;
                    }
                }
                if (flag) break;
            }
            for (int j = 0; j < list.size(); j++) {
                if (temp < list.get(j)) break;
                if (temp == list.get(j)) count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}