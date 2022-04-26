package com.company;

import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static boolean[] visited;
    static int[][] graph;
    static int N;
    static int MIN = 2147483647;
    public static void main(String[] args) {
        N = s.nextInt();
        graph = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = s.nextInt();
            }
        }

        bf(0, 0);

        System.out.print(MIN);
    }

    static void bf(int pre, int cnt) {
        if(cnt == N/2) {
            int sum = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i] && visited[j]) {
                        sum+=graph[i][j];
                    } else if(!visited[i] && !visited[j]) {
                        sum-=graph[i][j];
                    }
                }
            }
            sum = Math.abs(sum);
            if(sum < MIN) {
                MIN = sum;
            }
            return;
        }

        for(int i = pre ; i < N; i++) {
            if(visited[i])  {continue;}
            visited[i] = true;
            int a = cnt+1;
            bf(i, a);
            visited[i] = false;
        }
    }
}
