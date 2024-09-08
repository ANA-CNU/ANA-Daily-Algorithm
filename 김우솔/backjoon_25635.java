package Greedy;

import java.io.*;
import java.util.*;

public class backjoon_25635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long sum = 0;
        List<Long> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            long temp = Long.parseLong(st.nextToken());
            list.add(temp);
            sum += temp;
        }
        Collections.sort(list, Comparator.reverseOrder());

        long max = list.get(0);//제일 큰 값
        sum -= max;

        long ans = 0;
        long lo;
        long hi;
        for (int i = 1; i < n; i++) { //무조건 끝에는 뭐가 남는다 2 2 2 2처럼 딱 떨어지는것이 아니면
            lo = list.get(i - 1);
            hi = list.get(i);
            if (hi > lo) {
                ans += lo * 2;
                //arr[i] -= lo;
                list.set(i, hi - lo);
            } else if (hi < lo) {
                ans += hi * 2;
                //arr[i] = lo - hi;
                list.set(i, lo - hi);
            }else {
                ans += hi * 2;
                list.set(i, 0L);
                list.set(i - 1, 0L);
                i++;
            }
        }

        //if (arr[n - 1] > 0) sum += 1;
        //if (n == 1) sum = arr[0] - 1;
        if (max > sum) ans++;
        else ans += list.get(n - 1);

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}
/**
 1 1 3
 0 0 3

 3 1 1
 0 0 1

 1 2 3 4 5
 0 0 0 0 3

 5 4 3 2 1
 0 0 0 0 1

 2 2 2 2 2
 0 0 0 0 2

 2 1 5 3 4
 0 0 0 0 3

 10 1 1 1 1
 0 0 0 0 6 //5 모두 까는지 아니면 하나만 까는지의 기준은?

 8 2 2 2 2 같을 경우는 제외
 */