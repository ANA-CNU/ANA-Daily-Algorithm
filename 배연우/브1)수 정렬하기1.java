package com.company;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        int N = s.nextInt();
        int[] list = new int[N];
        for (int i = 0; i < N; i++) {
            list[i] = s.nextInt();
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N-i; j++) {
                if(list[j] > list[j+1]) {
                    int tmp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = tmp;
                }
            }
        }

        for(int i : list) {
            System.out.println(i);
        }
    }


}
