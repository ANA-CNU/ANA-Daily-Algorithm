package com.company;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] Args) throws IOException {
        ArrayList<Integer> arr = new ArrayList<>();
        int max = -1;
        while(true) {
            int in = Integer.parseInt(br.readLine());
            if(in == 0) {
                break;
            }
            arr.add(in);
            max = Math.max(max, in);
        }

        int[] soSu = new int[max*2+1];
        for (int i = 0; i <max*2+1; i++) {
            soSu[i] = i;
        }

        for (int i = 2; i <max*2+1; i++) {
            if(soSu[i] == 0) {
                continue;
            }
            int tar = soSu[i];
            for (int j = tar * 2; j < max*2+1; j+=tar) {
                soSu[j] = 0;
            }
        }

        for (int i : arr) {
            int cnt = 0;
            for (int j = i+1; j < i*2+1; j++) {
                if(soSu[j] != 0) {
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}