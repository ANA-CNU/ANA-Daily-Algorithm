package com.company;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.OutputStreamWriter;


public class Main {
    static int M, N;
    static Scanner s = new Scanner(System.in);
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] ans = new int[N];
    public static void main(String[] args) throws IOException{
        M = s.nextInt();
        N = s.nextInt();
        btk(new int[0]);
        bw.flush();
    }

    static void btk(int[] ans) throws IOException {
        if(ans.length == N) {
            printArray(ans);
            return;
        }

        int[] ansa = new int[ans.length + 1];
        System.arraycopy(ans, 0, ansa, 0, ans.length);
        for(int i = 1 ; i <= M; i++) {
            ansa[ans.length] = i;
            btk(ansa);
        }
    }

    static void printArray(int[] tans) throws IOException {
        for(int i : tans) {
            bw.write(i+ " ");
        }
        bw.write("\n");
    }
}
