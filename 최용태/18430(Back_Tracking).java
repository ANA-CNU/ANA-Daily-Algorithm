import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.io.*;


public class Main {
    static int N;
    static int M;
    static int[][] a;
    static boolean[][] visited;
    static int ans = 0;

    public static int calculate(int i, int j, int t) throws IOException {
        int[] type={0,1,2,3,4};
        int sum=a[i][j]*2;

        switch(type[t]) {
            case 1:
                sum+=a[i-1][j]+a[i][j-1];
                break;
            case 2:
                sum+=a[i-1][j]+a[i][j+1];
                break;
            case 3:
                sum+=a[i+1][j]+a[i][j-1];
                break;
            case 4:
                sum+=a[i+1][j]+a[i][j+1];
                break;
        }

        return sum;
    }
    public static void dualVisiting(int i,int j,int t){
        int[] type={0,1,2,3,4};
        visited[i][j]=!visited[i][j];

        switch(type[t]) {
            case 1:
                visited[i-1][j]=!visited[i-1][j];
                visited[i][j-1]=!visited[i][j-1];
                break;
            case 2:
                visited[i-1][j]=!visited[i-1][j];
                visited[i][j+1]=!visited[i][j+1];
                break;
            case 3:
                visited[i+1][j]=!visited[i+1][j];
                visited[i][j-1]=!visited[i][j-1];
                break;
            case 4:
                visited[i+1][j]=!visited[i+1][j];
                visited[i][j+1]=!visited[i][j+1];
                break;
        }
    }
    public static boolean isVisited(int i,int j,int t){
        int[] type={0,1,2,3,4};
        boolean V=false;

        switch(type[t]) {
            case 1:
                V=visited[i-1][j] || visited[i][j-1];
                break;
            case 2:
                V=visited[i-1][j] || visited[i][j+1];
                break;
            case 3:
                V=visited[i+1][j] || visited[i][j-1];
                break;
            case 4:
                V=visited[i+1][j] || visited[i][j+1];
                break;
        }
        return V;
    }

    public static void search(int n, int sum, int I) throws IOException {
            ans = Math.max(ans, sum);
            for (int i = I; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j]) {
                        if (i - 1 >= 0 && j - 1 >= 0 && !isVisited(i, j, 1)) {
                            dualVisiting(i, j, 1);
                            search(n + 1, sum+calculate(i, j, 1), i);
                            dualVisiting(i, j, 1);
                        }
                        if (i - 1 >= 0 && j + 1 < M && !isVisited(i, j, 2)) {
                            dualVisiting(i, j, 2);
                            search(n + 1, sum+calculate(i, j, 2), i);
                            dualVisiting(i, j, 2);
                        }
                        if (i + 1 < N && j - 1 >= 0 && !isVisited(i, j, 3)) {
                            dualVisiting(i, j, 3);
                            search(n + 1, sum+calculate(i, j, 3), i);
                            dualVisiting(i, j, 3);
                        }
                        if (i + 1 < N && j + 1 < M && !isVisited(i, j, 4)) {
                            dualVisiting(i, j, 4);
                            search(n + 1, sum+calculate(i, j, 4), i);
                            dualVisiting(i, j, 4);
                        }
                    }
                }
            }
        }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        a = new int[N][M];
        visited=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(ss.nextToken());
            }
        }

        search(0,0,0);
        System.out.println(ans);
    }
}