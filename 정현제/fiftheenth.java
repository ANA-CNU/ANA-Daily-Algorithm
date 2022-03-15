package grap_my_hand;

import java.io.*;
import java.util.*;

public class fiftheenth {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int A, B;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int minNum = Math.min(A, B);
            if(minNum == A) { 
                while(true) { // 1.
                    if(B - A < A) break;
                    B/=2;
                }
            } else {
                while(true) {
                    if(A - B < B) break;
                    A/=2;
                }
            }

            while (A != B) { // 2.
                if(A > B) {
                    A /= 2;
                    if(A== B) break;
                    B /= 2;
                }
                else {
                    B /=2;
                    if(A == B) break;
                    A/=2;
                }
            }
            bw.append((A*10)+"\n");
        }
        bw.flush();
        bw.close();
    }
}