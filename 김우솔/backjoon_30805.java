package havetostudy;

import java.io.*;
import java.util.*;

public class backjoon_30805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int[] arra = new int[a];
        boolean[] visa = new boolean[a];
        Arrays.fill(visa, true);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            arra[i] = Integer.parseInt(st.nextToken());
        }

        int b = Integer.parseInt(br.readLine());
        int[] arrb = new int[b];
        boolean[] visb = new boolean[b];
        Arrays.fill(visb, true);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            arrb[i] = Integer.parseInt(st.nextToken());
        }

        /**
         * 그리디...를 봐버렸다
         */
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            int amax = -1;
            int aindex = -1, bindex = -1;
            for (int i = a - 1; i >= 0; i--) {
                if (amax <= arra[i] && visa[i]) {
                    amax = arra[i];
                    aindex = i;
                }
            }

            int bmax = -1;
            for (int i = b - 1; i >= 0; i--) {
                if (bmax <= arrb[i] && visb[i]) {
                    bmax = arrb[i];
                    bindex = i;
                }
            }

            if (amax == -1 && bmax == -1) break;

            if (amax == bmax) {
                list.add(amax);
                for (int i = 0; i <= aindex; i++) {
                    visa[i] = false;
                }
                for (int i = 0; i <= bindex; i++) {
                    visb[i] = false;
                }
            }else if (amax > bmax){
                visa[aindex] = false;
            }else {
                visb[bindex] = false;
            }
        }

        if (list.isEmpty()) {
            bw.write(0 + "\n");
        }else {
            bw.write(list.size() + "\n");
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + " ");
            }
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}