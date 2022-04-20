package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] inNum;
    static int cnt;
    static int max = -10_0000_0001;
    static int min = 10_0000_0001;
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        cnt = s.nextInt();
        inNum = new int[cnt];
        for(int i = 0; i < cnt; i++) {
            inNum[i] = s.nextInt();
        }

        int[] op = new int[4];
        for(int i = 0 ; i < 4; i++) {
            op[i] = s.nextInt();
        }

        bf(op, inNum[0]);

        System.out.println(max);
        System.out.println(min);
    }

    static void bf(int[] op, int num) {
        int opCnt = sigma(op);
        if(opCnt == 0) {
            checkMaxMin(num);
            return;
        }
        int tarNum = inNum[cnt - opCnt];

        for(int i = 0; i< 4; i++) {
            if(op[i] > 0) {
                op[i]--;

                switch (i) {
                    case 0: bf(op, num + tarNum); break;
                    case 1: bf(op, num - tarNum); break;
                    case 2: bf(op, num * tarNum); break;
                    case 3: bf(op, num / tarNum); break;
                }

                op[i]++;
            }
        }
    }

    static int sigma(int[] tar) {
        int a= 0;
        for (int j : tar) {
            a += j;
        }
        return a;
    }

    static void checkMaxMin(int tar) {
        if(max < tar) {
            max = tar;
        }
        if(min > tar) {
            min = tar;
        }
    }
}