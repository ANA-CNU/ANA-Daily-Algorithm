import java.util.*;
import java.io.*;


public class Main {
    static int N = 0;
    static int MAX_COUNT = 0;
    static boolean DEBUG = false;

    public static void sumOfBlock_Type0(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) { // 수직이므로, sum 작업을 j(-->)번 반복해야한다.
            for (int i = 0; i < N; i++) {
                boolean isZero=false;
                start = i;
                while (start + 1 < N && Z048[start + 1][j] == 0) start++; // 0이 아닌 수를 만날때까지 start 증가
                if (start + 1 < N && (Z048[start + 1][j] == Z048[i][j] || Z048[i][j]==0)) { // 만약 해당 위치와 현재 위치의 값이 같다면
                    if(Z048[i][j]==0) isZero=true;
                    Z048[i][j] += Z048[start + 1][j]; // 그 값을 합산한다.
                    Z048[start + 1][j] = 0; // 합산에 쓰인 숫자는 0으로 만든다.
                } // 해당 위치와 현재 값이 다를 경우는 아무작업 x
                if(isZero) i--;
            }
        }
    }

    public static void sumOfBlock_Type1(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) { // 수직이므로, sum 작업을 j(-->)번 반복해야한다.
            for (int i = N - 1; i >= 0; i--) {
                boolean isZero=false;
                start = i;
                while (start - 1 >=0 && Z048[start - 1][j] == 0) start--; // 0이 아닌 수를 만날때까지 start 증가
                if (start - 1 >=0 && (Z048[start - 1][j] == Z048[i][j] || Z048[i][j]==0)) { // 만약 해당 위치와 현재 위치의 값이 같다면
                    if(Z048[i][j]==0) isZero=true;
                    Z048[i][j] += Z048[start - 1][j]; // 그 값을 합산한다.
                    Z048[start - 1][j] = 0; // 합산에 쓰인 숫자는 0으로 만든다.
                } // 해당 위치와 현재 값이 다를 경우는 아무작업 x
                if(isZero) i++;
            }

        }
    }

    public static void sumOfBlock_Type2(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                boolean isZero=false;
                start = i;
                while (start + 1 < N && Z048[j][start + 1] == 0) start++; // 0이 아닌 수를 만날때까지 start 증가
                if (start + 1 < N && (Z048[j][start+1] == Z048[j][i]|| Z048[j][i]==0)) { // 만약 해당 위치와 현재 위치의 값이 같다면
                    if(Z048[j][i]==0) isZero=true;
                    Z048[j][i] += Z048[j][start + 1]; // 그 값을 합산한다.
                    Z048[j][start + 1] = 0; // 합산에 쓰인 숫자는 0으로 만든다.
                } // 해당 위치와 현재 값이 다를 경우는 아무작업 x
                if(isZero) i--;
            }
        }
    }

    public static void sumOfBlock_Type3(int[][] Z048) {
        int start = 0;
        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i >= 0; i--) {
                boolean isZero=false;
                start = i;
                while (start - 1 >= 0 && Z048[j][start - 1] == 0) start--; // 0이 아닌 수를 만날때까지 start 증가
                if (start - 1 >= 0 && (Z048[j][start - 1] == Z048[j][i]|| Z048[j][i]==0)) { // 만약 해당 위치와 현재 위치의 값이 같다면
                    if(Z048[j][i]==0) isZero=true;
                    Z048[j][i] += Z048[j][start - 1]; // 그 값을 합산한다.
                    Z048[j][start - 1] = 0; // 합산에 쓰인 숫자는 0으로 만든다.
                } // 해당 위치와 현재 값이 다를 경우는 아무작업 x
                if(isZero) i++;
            }
        }
    }

    public static void search(int n, int[][] a, int t) {
        int[][] Z048 = new int[N][N];
        int[][] Prev2048 = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Z048[i][j] = a[i][j];
                Prev2048[i][j]=a[i][j];
            }
        }
        print(Z048,"Type: "+t,n);
        if(!DEBUG) {
        if (n == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    MAX_COUNT = Math.max(MAX_COUNT, Z048[i][j]);
                }
            }
            return;
        } else {
            for (int nextType = 0; nextType < 4; nextType++) {
                    switch (nextType) {
                        case 0:
                            sumOfBlock_Type0(Z048); // 상
                            break;
                        case 1:
                            sumOfBlock_Type1(Z048); // 하
                            break;
                        case 2:
                            sumOfBlock_Type2(Z048); // 좌
                            break;
                        case 3:
                            sumOfBlock_Type3(Z048); // 우
                            break;
                    }
                    search(n + 1, Z048, nextType);

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++)
                            Z048[i][j] = Prev2048[i][j];
                    }
            }
        }
    }else{
            switch (t){
                case 0:
                    sumOfBlock_Type0(Z048); // 상
                    break;
                case 1:
                    sumOfBlock_Type1(Z048); // 하
                    break;
                case 2:
                    sumOfBlock_Type2(Z048); // 좌
                    break;
                case 3:
                    sumOfBlock_Type3(Z048); // 우
                    break;
            }
        }

    }

    public static void initAndSearch() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] Z048 = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                Z048[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        search(0, Z048, -1);
    }

    public static void run() throws IOException {
        initAndSearch();
        System.out.println(MAX_COUNT);
    }

    public static void main(String[] args) throws IOException {
        run();
    }

       public static void print(int[][] a,String msg,int n){
        System.out.println(msg+"-----------------------");
        System.out.println("n="+n);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(a[i][j] + " ");
            System.out.println();
        }
    }
}

